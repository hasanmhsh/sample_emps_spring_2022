package hasan.mohamed.shehata.sampleemps.exceptions;

public class ResourceFoundException
        extends RuntimeException
{
    public ResourceFoundException(String message)
    {
        super("Error from Backend Application " + message);
    }
}
