package entities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Joao
 */
public final class UsedProduct extends Product{
    
    private final static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    private Date manufactureDate;
    
    public UsedProduct() {
        super();
    }

    public UsedProduct(Date manufactureDate, String name, Double price) {
        super(name, price);
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }
    
    @Override
    public String priceTag() {
        return getName() 
                + " (used) $ "
                + String.format("%.2f", getPrice())
                + " (Manufacture date: "
                + sdf.format(manufactureDate) 
                + ")";
    }
}
