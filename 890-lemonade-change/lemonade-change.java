class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveDollarBills = 0;
        int tenDollarBills = 0;
      
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    fiveDollarBills++;
                    break;
                  
                case 10:
                    tenDollarBills++;
                    fiveDollarBills--;
                    break;
                  
                case 20:
                    if (tenDollarBills > 0) {
                        tenDollarBills--;
                        fiveDollarBills--;
                    } else {
                        fiveDollarBills -= 3;
                    }
                    break;
            }
          
            if (fiveDollarBills < 0) {
                return false;
            }
        }
      
        return true;
    }
}