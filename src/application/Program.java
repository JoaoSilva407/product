package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Joao
 */
public class Program {

    public static void main(String[] args) throws ParseException {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        
        List<Product> product = new ArrayList<>();
        
        System.out.print("Enter the number of products: ");
        int n = input.nextInt();
        
        for(int i=1; i<=n; i++) {
            System.out.println("Product #" + i+ " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char tag = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Price: ");
            double price = input.nextDouble();
            
            if(tag == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = input.nextDouble();
                
                product.add(new ImportedProduct(customsFee, name, price));
            }
            else if(tag == 'u') {
                System.out.print("Manufacture date: ");
                Date manufactureDate = sdf.parse(input.next());
                
                product.add(new UsedProduct(manufactureDate, name, price));
            }
            else {
                product.add(new Product(name, price));
            }           
        }
        
        System.out.println();
        System.out.println("PRICE TAGS");
        for(Product pro : product) {
            System.out.println(pro.priceTag());
        }
        
        input.close();
    }
    
}
