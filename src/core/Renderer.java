package core;

import org.jsfml.graphics.RenderWindow;
import org.jsfml.system.Time;
import org.jsfml.system.Vector2i;
import org.jsfml.window.VideoMode;
import org.jsfml.window.event.Event;


public class Renderer
{
    private RenderWindow _renderWindow = new RenderWindow();


    public boolean create(String title, int width, int height)
    {
        _renderWindow.create(new VideoMode(width, height), title, 4);
        _renderWindow.setVerticalSyncEnabled(true);

        return true;
    }

    public void update(Time time)
    {
        _renderWindow.clear();
        _renderWindow.display();

        for (Event event : _renderWindow.pollEvents())
        {
            if (event.type == Event.Type.CLOSED)
            {
                Game.getInstance().quit();
            }
        }
    }

    public void setMouseVisible(boolean enable)
    {
        _renderWindow.setMouseCursorVisible(enable);
    }

    public Vector2i getWindowSize()
    {
        return _renderWindow.getSize();
    }

    public void setWindowSize(int width, int height)
    {
        _renderWindow.setSize(new Vector2i(width, height));
    }
}
