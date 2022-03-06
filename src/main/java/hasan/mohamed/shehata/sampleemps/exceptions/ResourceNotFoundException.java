package hasan.mohamed.shehata.sampleemps.exceptions;

public class ResourceNotFoundException
        extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super("Error from Backend Application " + message);
    }
}
