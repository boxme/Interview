import java.util.*;

class q7
{
    public static void main(String[] args)
    {
    }
}

class ConvertIntToEng
{
    HashMap<Integer, String> intToEngMap;
    String[] digits;
    String[] tens;
    String[] teens;
    String[] bigNum;

    public ConvertIntToEng
    {
	digits = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	tens = {"zero", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	teens = {"zero", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"}
	bigNum = {"", thousand", "million"};
    }

    public static String numToString(int number)
    {
	if (number < 0)
	{
	    return "Negative " + numToString(-number);
	}

	if (number == 0)
	{
	    return "Zero";
	}

	int count = 0;
	String str = "";
	while (number > 0)
	{
	    str = numToString100(number % 1000) + bigNum[count] + " " + str;

	    number /= 1000;
	    count++;
	}

	return str;
    }
    
    public static String numToString100(int number)
    {
	String str = "";

	// Convert hundreds
	if (number >= 100)
	{
	    str = digits[num / 100] + " hundred ";
	    number %= 100;
	}

	// Convert tens
	if (number > 10 && number < 20)
	{
	    str += teens[number / 10] + " ";
	    return str;
	}
	else if (number == 10 || number >= 20)
	{
	    str += tens[number / 10] + " ";
	    number %= 10;
	}

	// Convert digits
	if (number > 0 && number < 10])
	{
	    str += digits[number] + " ";
	}

	return str;
    }
}
