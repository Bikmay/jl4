import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Order {

    static boolean CheckOpportunity = true;
    static Dish[] MassOfFood;
    static int index=0;

    Order()
    {
         MassOfFood = new Dish[16];

    }

    Order(int NumberOfElements)
    {
        MassOfFood = new Dish[NumberOfElements];
    }

    Order(Dish[] MassOfFood)
    {

    }
// указание про сложность методов добавления, удаления, поиска и возврата размера актуально
    // стоит использовать System.arrayCopy
    public boolean addToOrder(Dish Food)
    {

        MassOfFood[index] = Food;

        for (int i =0;i<MassOfFood.length;i++)
        {
            if (MassOfFood[i] == null)
            {
                MassOfFood[i]=Food;
                return true;
            }

        }
        return false;
    }

    public static boolean deleteOneFood(String NameFindFood)
    {
        for(int i=0;i<MassOfFood.length;i++)
        {
            if(NameFindFood == MassOfFood[i].NameOfFood)
            {
                MassOfFood[i]=null;
                return true;
            }


        }
        return false;

    }

    public static int deleteFoods(String NameFindFood)
    {
        int count=0;
        for(int i=0;i<MassOfFood.length;i++)
        {
            if(NameFindFood == MassOfFood[i].NameOfFood)
            {
                MassOfFood[i]=null;
                count+=1;

                System.arraycopy(MassOfFood,i,MassOfFood,i+1,MassOfFood.length-i-1);
            }


        }
        return count;
    }

    public static Dish[] returnDishs()
    {
        Dish[] ResultMass = new Dish[MassOfFood.length];

        for(int i =0;i<MassOfFood.length;i++)
        {
            if(MassOfFood==null)break;
            ResultMass[i]=MassOfFood[i];
        }

        return ResultMass;

    }

    public double returnCostOfOrder()
    {
        double sum =0;

        for (int i =0;i<MassOfFood.length;i++)
        {
            sum+=MassOfFood[i].costOfOrder();
        }

        return sum;
    }

    public int numberDishsOfOrder(String nameOfDish)
    {
        Dish[] MassOfDish = returnDishs();

        int niga=0;

        for (int i =0; i<MassOfDish.length;i++)
        {
            if(nameOfDish == MassOfDish[i].getNameOfFood())
            {
                niga++;
            }
        }
        return niga;
    }

    public static String[] getMassOfDish ()
    {
        int niga=MassOfFood.length;
        int R_a=0;

        for (int i =0;i<MassOfFood.length;i++)
        {
            for (int j=0;j<MassOfFood.length;j++)
            {
                if(MassOfFood[i].getNameOfFood()==MassOfFood[j].getNameOfFood())
                {
                    if(R_a>0)
                    {
                        niga-=1;
                    }
                    R_a++;

                }
            }
        }

        String[] ReturNames = new String[niga];
        boolean Checker=true;
        int k=0;

        for (int i =0;i<MassOfFood.length;i++)
        {
            for (int j=0;j<ReturNames.length;j++)
            {
                if(MassOfFood[i].getNameOfFood()==MassOfFood[j].getNameOfFood())
                {
                    Checker= false;

                }

            }
            if (Checker==true)
            {
                ReturNames[k]=MassOfFood[i].getNameOfFood();
                k++;
            }
        }

        return ReturNames;
    }

    public static Dish[] getSortMassDishs()
    {
        Dish[] w_dishmass = returnDishs();
        double[] w_mass = new double[w_dishmass.length];
        Dish[] ResMass = new Dish[w_dishmass.length];

        for (int i =0;i<w_dishmass.length;i++)
        {
            w_mass[i]=w_dishmass[i].costOfOrder();
        }
        w_mass=quickSort(w_mass,0,w_mass.length-1);
        for (int i=0;i<w_mass.length;i++)
        {
            for(int j =0;j<ResMass.length;j++)
            {
                if(w_dishmass[j].costOfOrder()==w_mass[i])
                {
                    ResMass[i]=w_dishmass[j];
                    w_dishmass[j] = null;
                }
            }
        }
        return ResMass;
    }

    private static double[] quickSort(double[] mass,int b,int e) {
        int l = b, r = e;

        double piv = mass[(b + e) / 2];

        do {
            while (mass[l] < piv) l++;
            while (mass[r] > piv) r--;

            if (l <= r) mass=swap(mass,l,r);


        } while (l <= r);

        if(b<r) quickSort(mass,b,r);
        if(e>l) quickSort(mass,l,e);

        return mass;
    }  //Быстрая сортировака


    private static double[]  swap(double[] mass, int firstIndex,int secondIndex)
    {
        double copyFirstValue;

        copyFirstValue= mass[firstIndex];
        mass[firstIndex]=mass[secondIndex];
        mass[secondIndex]=copyFirstValue;

        return mass;
    }


}
