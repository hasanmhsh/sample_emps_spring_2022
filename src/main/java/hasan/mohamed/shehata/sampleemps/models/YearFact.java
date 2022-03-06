package hasan.mohamed.shehata.sampleemps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// needed to ignore any fields coming across that we do not want in our final class.
@JsonIgnoreProperties(ignoreUnknown = true)
public class YearFact
{
    private String text;
    private int number;

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public int getNumber()
    {
        return number;
    }

    public void setNumber(int number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "YearFact{" +
                "text='" + text + '\'' +
                ", number=" + number +
                '}';
    }
}