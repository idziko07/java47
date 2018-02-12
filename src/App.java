import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
    public static void main(String[] args){

        try(Scanner input = new Scanner(new File("produkct.csv"))){
           Product[] prod = new Product[5];
            input.useLocale(Locale.US);
            int i=0;
            while(input.hasNext()){
                    String nazwa = input.next();
                    String producent = input.next();
                    double cena = input.nextDouble();

                    prod[i] = new Product(nazwa, producent, cena);
                    System.out.println(prod[i].toString());
                    i++;
            }
            input.close();

           System.out.println("Cena wszystkich produktów to: " +suma(prod));
           najdrozszy(prod);
           System.out.println(nameProduckt(prod));

        }catch (FileNotFoundException e){
            System.err.println("Plik nie istnieje");
        }catch (NoSuchElementException e){
            System.out.println("bład");
        }

    }


    static double suma(Product[] products){
        double sum = 0;
        for (int i=0; i<products.length; i++){
            sum +=products[i].getCena();
        }
        return sum;
    }

    static void najdrozszy(Product[] products){
        double cena = products[0].getCena();
        int y = 0;
        for (int i = 1; i < products.length; i++) {
            if(cena < products[i].getCena()){
                cena = products[i].getCena();
                y=i;
            }
        }
        System.out.println("Najdroższy produkt to: " + products[y].toString());
    }

    static String nameProduckt(Product[] products){
        int ilosc = 0, licznik = 0;
        int nazwa = 0, n = 1;
        for (int i= 0; i <products.length;i++){
            for (int y= n ; y<products.length;y++){
                if(products[i].getProducent().equals(products[y].getProducent())){
                    ilosc++;
                    if(ilosc > licznik) {
                        licznik = ilosc;
                        nazwa = i;
                        ilosc = 0;
                    }
                }
            }
          n++;
        }
        String wynik;
        if(licznik == 0){
            wynik ="Wszyscy producenci wystepuje tylko raz";
        }else if (licznik == ilosc){
            wynik = "Dwoch lub wicej producentow ma taka sama ilosc";
        }else{
          wynik ="Najwiecej produktów ma: " + products[nazwa].getProducent();
        }
        return wynik;
    }

}



