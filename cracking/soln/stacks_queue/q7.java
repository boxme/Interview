import java.util.*;

public static void main(String[] args)
{
}

class Animal
{
    public static final DOG = "dog";
    public static final CAT = "cat";

    long time;
    String type;

    void setTime(long time)
    {
	this.time = time;
    }

    String getType()
    {
	return type;
    }
}

class Dog extends Animal
{
    public Dog()
    {
	super();
	type = Animal.DOG;
    }
}

class Cat extends Animal
{
    public Cat()
    {
	super();
	type = Animal.CAT;
    }
}

class AnimalShelter
{
    LinkedList<Dog> dogShelter;
    LinkedList<Cat> catShelter;

    public AnimalShelter()
    {
	dogShelter = LinkedList<>();
	catShelter = LinkedList<>();
    }

    public enqueue(Animal animal)
    {
	if (animal == null) return;
	
	final long time = System.currentTimeMillis();
	animal.setTime(time);

	if (Animal.DOG.equals(animal.getType())
	{
	    dogShelter.offer(animal);
	    return;
	}

	if (Animal.CAT.equals(animal.getType())
	{
	    catShelter.offer(animal);    
	    return;
	}
    }

    public Animal dequeueAny()
    {
	if (dogShelter.isEmpty()) return catShelter.poll();
	if (catShelter.isEmpty()) return dogShelter.poll();

	if (catShelter.peek().getTime() < dogShelter.peek().getTime())
	{
	    return catShelter.poll();
	}

	return dogShelter.poll();
    }

    public Dog dequeueDog()
    {
	return dogShelter.poll();
    }

    public Cat dequeueCat()
    {
	return catShelter.poll();
    }
}



