import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Warehouse {
    
    private Map<String, Integer> products;
    private Map<String, Integer> stockLevels;
    
    public Warehouse() {
        products = new HashMap<String, Integer>();
        stockLevels = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stockLevels.put(product, stock);
    }
    
    public int price(String product) {
        if (!this.products.containsKey(product)) {
            return -99;
        }
        return this.products.get(product);
    }
    
    public int stock(String product) {
        if (!this.stockLevels.containsKey(product)) {
            return 0;
        }
        return this.stockLevels.get(product);
    }
    
    public boolean take(String product) {
        if (!this.stockLevels.containsKey(product)) {
            return false;
        }
        int amount = this.stockLevels.get(product);
        if (amount > 1) {
            this.stockLevels.put(product, amount -1);
        }
        if (amount == 1) {
            this.stockLevels.remove(product);
            this.products.remove(product);
            return false;
        }
        return true;
    }
    
    public Set<String> products() {
        return this.stockLevels.keySet();
    }
    
    
}
