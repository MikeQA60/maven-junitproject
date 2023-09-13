package steps;

import io.cucumber.java.DataTableType;
import models.Claim;
import models.Order;


import java.util.Map;

public class DataTableTransFormer {

    @DataTableType
    public Order orderEntry(Map<String, String> entry) {
        int orderId = Integer.valueOf(entry.get("orderID"));
        String product = entry.get("product");
        int quantity = Integer.valueOf(entry.get("quantity"));

        return new Order (orderId, product,quantity);

    }

    @DataTableType
    public Claim claimEntry(Map<String, String> entry) {
        //    | claim ID | amount   | date       | description      | supporting Documents    |

        String claimId = entry.get("claimID");
       double amount = Double.valueOf(entry.get("amount"));
       String date = entry.get("date");
       String description = entry.get("description");
       String supportingDocuments = entry.get("supportingDocuments");

       return new Claim(claimId,amount, date, description, supportingDocuments);
    }
}
