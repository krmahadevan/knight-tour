package rationale.emotions.pojo;

/**
 * A simple POJO (Plain Old Java Object) class that represents any given location using its x and y co-ordinates.
 *
 */
public class Location {
    protected int xCoordinates;
    protected int yCoordinates;

    /**
     * @param x - The x co-ordinates.
     * @param y - The y co-ordinates.
     */
    public Location(int x, int y) {
        this.xCoordinates = x;
        this.yCoordinates = y;
    }

    /**
     * @return the xCoordinates
     */
    public int getX() {
        return xCoordinates;
    }

    /**
     * @return the yCoordinates
     */
    public int getY() {
        return yCoordinates;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + xCoordinates;
        result = prime * result + yCoordinates;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Location other = (Location) obj;
        if (xCoordinates != other.xCoordinates)
            return false;
        if (yCoordinates != other.yCoordinates)
            return false;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Location (");
        builder.append(xCoordinates);
        builder.append(", ");
        builder.append(yCoordinates);
        builder.append(")");
        return builder.toString();
    }

}
