package core.objects;

import org.jsfml.system.Time;

import java.awt.geom.Rectangle2D;


public abstract class Actor
{
    static private long idPool = 0;

    private long _id = ++idPool;
    private Rectangle2D _collisionBox;
    String _name;

    boolean create()
    {
        return true;
    }

    void update(Time time)
    {

    }

    public float getId()
    {
        return _id;
    }

    public Rectangle2D getCollisionBox()
    {
        return _collisionBox;
    }

    public double[] getPosition()
    {
        return new double[] {_collisionBox.getX(), _collisionBox.getY()};
    }

    public void setPosition(double x, double y)
    {
        double[] size = getSize();
        _collisionBox.setRect(x, y, size[0], size[1]);
    }

    public double[] getSize()
    {
        return new double[] {_collisionBox.getWidth(), _collisionBox.getHeight()};
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }
}
