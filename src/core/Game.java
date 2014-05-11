package core;

import org.jsfml.system.Clock;
import org.jsfml.system.Time;


public class Game
{
    static private Game _instance;
    private boolean _running = false;

    private Renderer _renderer = new Renderer();
    private Logic _logic = new Logic();

    private Clock _clock = new Clock();


    static Game getInstance()
    {
        return _instance;
    }

    public Game() throws AssertionError
    {
        if (_instance != null)
        {
            throw new AssertionError("Game singleton already exists");
        }

        _instance = this;
    }

    public void run(String[] args) throws Error
    {
        if (!onCreate())
        {
            throw new Error("Could not initialize the game.");
        }

        _running = true;
        while (_running)
        {
            onUpdate(_clock.restart());
        }
    }

    public void quit()
    {
        _running = false;
    }

    private boolean onCreate()
    {
        _logic.create();
        _renderer.create("Platformer", 640, 480);

        return true;
    }

    private void onUpdate(Time time)
    {
        _logic.update(time);
        _renderer.update(time);
    }

    public Renderer getRenderer()
    {
        return _renderer;
    }
}
