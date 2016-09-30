/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author CJ Lapuz; FA Zauleck; JM Reqioma 
 */

import java.util.*;

public class LargeInteger {
    
    final int DECREASE_BY = -1;
    final int BASE_INDEX = 0;
    final int RAISED_TO = 10;
    final int TO_INT = 48;
    final int MAX_DIGITS = 50;
    final int NEG = -1;
    final int ZERO = 0;
    final int POS = 1;
    final char NEGATION = '-';
    final char DIGIT_START = '0';
    final char DIGIT_END = '9';
    
    private char[] largeInt = new char[MAX_DIGITS];
    private int sign = 0;
    private int value = 0;

    public LargeInteger(){
        this.largeInt = new char[50];
        this.sign = ZERO;
    }
    
    public LargeInteger(String input){
        for (int i = 0; i <input.length(); i++) {
            if (!(DIGIT_START <= input.charAt(i) && input.charAt(i) <= DIGIT_END || input.charAt(0) == '-')){
                throw new IllegalArgumentException("Non-numeric input is not allowed!");
            }
            setLargeInt(input.toCharArray());
        }
    }
    
    public LargeInteger(long input){
        String lung = String.valueOf(input);
        setLargeInt(lung.toCharArray());
    }
     
    public LargeInteger(char[] input){
        setLargeInt(input);
    }
    
    public LargeInteger(LargeInteger input){
        setLargeInt(input.getLargeInt());
    }
    
    public LargeInteger(LargeInteger input, int sign){
        char[] val = input.getLargeInt();
        String newVal = new String(val);
        if (sign == NEG) {
            String neWVal = newVal.trim(); 
            String newErVal = "-" + neWVal;
            val = newErVal.toCharArray();
        }else {
            val = input.getLargeInt();
        }
        setLargeInt(val);
    }
    
    public boolean firstIsLarger(LargeInteger first, LargeInteger second){
        for(int i = 0; i < first.length(); i++){
            if (first.charAt(i) < second.charAt(i)){
                return false;
            }
        }
        return true;
    }
    
    public LargeInteger getPositive(){
            String large = new String(this.largeInt);
            StringTokenizer tok = new StringTokenizer(large, "-");
            large = tok.nextToken();
            this.largeInt = large.toCharArray();
            LargeInteger posVal = new LargeInteger(largeInt);
            return posVal;
    }
    public int length(){
        return this.largeInt.length;
    }
    
    public boolean isEqualLength(int l1, int l2){
        return l1 == l2;
    }
    
    public void setCharAt(int index, char value){
        int newVal = 0;
        int val = (int) value;
        if (this.largeInt[index] != '\0'){
            if (val + (int) this.largeInt[index]- TO_INT - TO_INT >= RAISED_TO){
                this.largeInt[index - 1] = '1';
                val -= RAISED_TO;
           } 
           newVal = (this.largeInt[index] + val) - TO_INT;
           this.largeInt[index] = (char)newVal;
        } else {
            this.largeInt[index] = value;    
        }
    }
    
    public char charAt(int index){
        return this.largeInt[index];
    }
    
    
    public LargeInteger add(LargeInteger higher, LargeInteger lower){
        LargeInteger res1 = new LargeInteger();
        higher.getPositive();
        lower.getPositive();
        int i = 1;
        value = 0;
        int lenLower = lower.length();
        int lenHigher = higher.length();
        for (; i <= lower.length(); i++) {
            value = lower.charAt(lenLower - i) + higher.charAt(lenHigher - i) - TO_INT;
            if (value - TO_INT >= RAISED_TO){
                res1.setCharAt(MAX_DIGITS - i - 1, '1');
                value -= RAISED_TO;
            }
            res1.setCharAt(MAX_DIGITS - i, (char)value);
        }
        if (!isEqualLength(lenHigher, lenLower)){
            i -= 1;
            for (int j = i; j < lenHigher; j++){
                value = higher.charAt(lenHigher - j - 1);
                res1.setCharAt(MAX_DIGITS - j - 1, (char)value);
            }
        }
        return res1;
    }
    
    public LargeInteger subtract(LargeInteger upper, LargeInteger lower){
        LargeInteger res1 = new LargeInteger();
        upper.getPositive();
        lower.getPositive();
        int i = 1;
        value = 0;
        int lenLower = lower.length();
        int lenHigher = upper.length();
        for (; i <= lenLower; i++) {
            value = (upper.charAt(lenHigher - i) - TO_INT) - (lower.charAt(lenLower - i) - TO_INT);
            if (value <= NEG){
                int up = upper.charAt(lenHigher - i) - TO_INT + 10;
                value = value + up;
                res1.setCharAt(MAX_DIGITS - i - 1, '/');
                value = Math.abs(value);
            }
            value += TO_INT;
            res1.setCharAt(MAX_DIGITS - i, (char)value);
        }
        if (!isEqualLength(lenHigher, lenLower)){
            i -= 1;
            for (int j = i; j < lenHigher; j++){
                value = upper.charAt(lenHigher - j - 1);
                res1.setCharAt(MAX_DIGITS - j - 1, (char)value);
            }
        }
        return res1;
    }
   
   
    //Adding a Large Integer and a String
    public LargeInteger add(String li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        int largeOneLen = largeOne.length();
        int largeTwoLen = largeTwo.length();
        int signum = 0;
        if (largeOne.charAt(0) == NEGATION){
            largeOneLen--;
        }
        if (largeTwo.charAt(0) == NEGATION){
            largeTwoLen--;
        }
        if (largeOne.sign == ZERO){
            return largeTwo;      }
        if (largeTwo.sign == ZERO){
            return largeOne;      }
        if (largeOne.length() > largeTwo.length()){
            signum = largeOne.sign;
            if (largeOne.sign == largeTwo.sign){
                res = add(largeOne, largeTwo);
            } else {
                res = subtract(largeOne, largeTwo);
            }
       }else if(largeOne.length() == largeTwo.length()){
           if(firstIsLarger(largeOne, largeTwo)){
               signum = largeOne.sign;
                if (largeOne.sign == largeTwo.sign){
                    res = add(largeOne, largeTwo);
                } else {
                    res = subtract(largeOne, largeTwo);
                }
           }else {
                signum = largeTwo.sign;
                if (largeOne.sign == largeTwo.sign){
                    res = add(largeTwo, largeOne);
                } else {
                    res = subtract(largeTwo, largeOne);
                }        
           }
       } else{
            signum = largeTwo.sign;
            if (largeOne.sign == largeTwo.sign ){
                res = add(largeTwo, largeOne);
            } else {
                res = subtract(largeTwo, largeOne);
            }
        }
        LargeInteger result = new LargeInteger(res, signum);
        return result;
    }
    
    //Adding a Large Integer and a Long
    public LargeInteger add(long li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        int largeOneLen = largeOne.length();
        int largeTwoLen = largeTwo.length();
        int signum = 0;
        if (largeOne.charAt(0) == NEGATION){
            largeOneLen--;
        }
        if (largeTwo.charAt(0) == NEGATION){
            largeTwoLen--;
        }
        if (largeOne.sign == ZERO){
            return largeTwo;      }
        if (largeTwo.sign == ZERO){
            return largeOne;      }
        if (largeOne.length() > largeTwo.length()){
            signum = largeOne.sign;
            if (largeOne.sign == largeTwo.sign){
                res = add(largeOne, largeTwo);
            } else {
                res = subtract(largeOne, largeTwo);
            }
       }else if(largeOne.length() == largeTwo.length()){
           if(firstIsLarger(largeOne, largeTwo)){
               signum = largeOne.sign;
                if (largeOne.sign == largeTwo.sign){
                    res = add(largeOne, largeTwo);
                } else {
                    res = subtract(largeOne, largeTwo);
                }
           }else {
                signum = largeTwo.sign;
                if (largeOne.sign == largeTwo.sign){
                    res = add(largeTwo, largeOne);
                } else {
                    res = subtract(largeTwo, largeOne);
                }        
           }
       } else{
            signum = largeTwo.sign;
            if (largeOne.sign == largeTwo.sign ){
                res = add(largeTwo, largeOne);
            } else {
                res = subtract(largeTwo, largeOne);
            }
        }
        LargeInteger result = new LargeInteger(res, signum);
        return result;
    }
    
    //Adding two Large Integers 
    public LargeInteger add(LargeInteger li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        int largeOneLen = largeOne.length();
        int largeTwoLen = largeTwo.length();
        int signum = 0;
        if (largeOne.charAt(0) == NEGATION){
            largeOneLen--;
        }
        if (largeTwo.charAt(0) == NEGATION){
            largeTwoLen--;
        }
        if (largeOne.sign == ZERO){
            return largeTwo;      }
        if (largeTwo.sign == ZERO){
            return largeOne;      }
        if (largeOne.length() > largeTwo.length()){
            signum = largeOne.sign;
            if (largeOne.sign == largeTwo.sign){
                res = add(largeOne, largeTwo);
            } else {
                res = subtract(largeOne, largeTwo);
            }
       }else if(largeOne.length() == largeTwo.length()){
           if(firstIsLarger(largeOne, largeTwo)){
               signum = largeOne.sign;
                if (largeOne.sign == largeTwo.sign){
                    res = add(largeOne, largeTwo);
                } else {
                    res = subtract(largeOne, largeTwo);
                }
           }else {
                signum = largeTwo.sign;
                if (largeOne.sign == largeTwo.sign){
                    res = add(largeTwo, largeOne);
                } else {
                    res = subtract(largeTwo, largeOne);
                }        
           }
       } else{
            signum = largeTwo.sign;
            if (largeOne.sign == largeTwo.sign ){
                res = add(largeTwo, largeOne);
            } else {
                res = subtract(largeTwo, largeOne);
            }
        }
        LargeInteger result = new LargeInteger(res, signum);
        return result;
    } 
    
    //Subtracting a Large Integer and a String
    public LargeInteger subtract(String li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        int largeOneLen = largeOne.length();
        int largeTwoLen = largeTwo.length();
        int signum = 0;
        if (largeOne.charAt(0) == NEGATION){
            largeOneLen--;
        }
        if (largeTwo.charAt(0) == NEGATION){
            largeTwoLen--;
        }
        if (largeOne.sign == ZERO){
            return new LargeInteger(largeTwo, largeTwo.sign);      
        }
        if (largeTwo.sign == ZERO){
            return largeOne;     
        }
        if (largeOne.length() > largeTwo.length()){
            signum = largeOne.sign;
            if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                res = subtract(largeOne, largeTwo);
            } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                res = subtract(largeTwo, largeOne); 
            } else {
                res = add(largeOne, largeTwo); 
            }
        }else if(largeOne.length() == largeTwo.length()){
            if(firstIsLarger(largeOne, largeTwo)){
                signum = largeOne.sign;
                if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                    res = subtract(largeOne, largeTwo);
                } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                    res = subtract(largeOne, largeTwo); 
                } else {
                    res = add(largeOne, largeTwo); 
                }
           }else {
               signum = largeTwo.sign;
                if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                    res.sign = NEG;
                    res = subtract(largeTwo, largeOne);
                } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                    res = subtract(largeTwo, largeOne); 
                } else {
                    signum = largeOne.sign;
                    res = add(largeOne, largeTwo); 
                }       
            }
       } else{
            signum = largeTwo.sign;
            if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                res.sign = NEG;
                res = subtract(largeTwo, largeOne);
            } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                res = subtract(largeTwo, largeOne); 
            } else {
                res.sign = largeOne.sign;
                res = add(largeOne, largeTwo); 
            }
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
    //Subtracting a Large Integer and a Long
    public LargeInteger subtract(long li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        int largeOneLen = largeOne.length();
        int largeTwoLen = largeTwo.length();
        int signum = 0;
        if (largeOne.charAt(0) == NEGATION){
            largeOneLen--;
        }
        if (largeTwo.charAt(0) == NEGATION){
            largeTwoLen--;
        }
        if (largeOne.sign == ZERO){
            return new LargeInteger(largeTwo, largeTwo.sign);      
        }
        if (largeTwo.sign == ZERO){
            return largeOne;     
        }
        if (largeOne.length() > largeTwo.length()){
            signum = largeOne.sign;
            if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                res = subtract(largeOne, largeTwo);
            } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                res = subtract(largeTwo, largeOne); 
            } else {
                res = add(largeOne, largeTwo); 
            }
        }else if(largeOne.length() == largeTwo.length()){
            if(firstIsLarger(largeOne, largeTwo)){
                signum = largeOne.sign;
                if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                    res = subtract(largeOne, largeTwo);
                } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                    res = subtract(largeOne, largeTwo); 
                } else {
                    res = add(largeOne, largeTwo); 
                }
           }else {
               signum = largeTwo.sign;
                if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                    res.sign = NEG;
                    res = subtract(largeTwo, largeOne);
                } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                    res = subtract(largeTwo, largeOne); 
                } else {
                    signum = largeOne.sign;
                    res = add(largeOne, largeTwo); 
                }       
            }
       } else{
            signum = largeTwo.sign;
            if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                res.sign = NEG;
                res = subtract(largeTwo, largeOne);
            } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                res = subtract(largeTwo, largeOne); 
            } else {
                res.sign = largeOne.sign;
                res = add(largeOne, largeTwo); 
            }
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
    //Subtracting two Large Integers
    public LargeInteger subtract(LargeInteger li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        int largeOneLen = largeOne.length();
        int largeTwoLen = largeTwo.length();
        int signum = 0;
        if (largeOne.charAt(0) == NEGATION){
            largeOneLen--;
        }
        if (largeTwo.charAt(0) == NEGATION){
            largeTwoLen--;
        }
        if (largeOne.sign == ZERO){
            return new LargeInteger(largeTwo, largeTwo.sign);      
        }
        if (largeTwo.sign == ZERO){
            return largeOne;     
        }
        if (largeOne.length() > largeTwo.length()){
            signum = largeOne.sign;
            if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                res = subtract(largeOne, largeTwo);
            } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                res = subtract(largeTwo, largeOne); 
            } else {
                res = add(largeOne, largeTwo); 
            }
        }else if(largeOne.length() == largeTwo.length()){
            if(firstIsLarger(largeOne, largeTwo)){
                signum = largeOne.sign;
                if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                    res = subtract(largeOne, largeTwo);
                } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                    res = subtract(largeOne, largeTwo); 
                } else {
                    res = add(largeOne, largeTwo); 
                }
           }else {
               signum = largeTwo.sign;
                if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                    res.sign = NEG;
                    res = subtract(largeTwo, largeOne);
                } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                    res = subtract(largeTwo, largeOne); 
                } else {
                    signum = largeOne.sign;
                    res = add(largeOne, largeTwo); 
                }       
            }
       } else{
            signum = largeTwo.sign;
            if ((largeOne.sign == POS) && (largeTwo.sign == POS)){
                res.sign = NEG;
                res = subtract(largeTwo, largeOne);
            } else if ((largeOne.sign == NEG) && (largeTwo.sign == NEG)){
                res = subtract(largeTwo, largeOne); 
            } else {
                res.sign = largeOne.sign;
                res = add(largeOne, largeTwo); 
            }
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
    //Multiplying a Large Integer and a String
    public LargeInteger multiply(String li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        if (largeOne.sign == ZERO){
            return new LargeInteger();      }
        if (largeTwo.sign == ZERO){
            return new LargeInteger();      }
        if (largeOne.sign == largeTwo.sign){
            //DO SOMTEIN
        } else {
            //sumtin
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
     //Multiplying a Large Integer and a Long
    public LargeInteger multiply(long li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        if (largeOne.sign == ZERO){
            return new LargeInteger();      }
        if (largeTwo.sign == ZERO){
            return new LargeInteger();      }
        if (largeOne.sign == largeTwo.sign){
            //DO SOMTEIN
        } else {
            //sumtin
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
     //Multiplying two Large Integers 
    public LargeInteger multiply(LargeInteger li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        if (largeOne.sign == ZERO){
            return new LargeInteger();      }
        if (li.sign == ZERO){
            return new LargeInteger();      }
        if (largeOne.sign == li.sign){
            //DO SOMTEIN
        } else {
            //sumtin
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
    //Dividing a Large Integer and a String
    public LargeInteger divide(String li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        if (largeOne.sign == ZERO){
            return new LargeInteger();      }
        if (largeTwo.sign == ZERO){
            System.out.println("ERR");      
            return null;
        }
        if (largeOne.sign == largeTwo.sign){
            //DO SOMTEIN
        } else {
            //sumtin
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
     //Dividing a Large Integer and a Long
    public LargeInteger divide(long li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        LargeInteger largeTwo = new LargeInteger(li);
        if (largeOne.sign == ZERO){
            return new LargeInteger();      }
        if (largeTwo.sign == ZERO){
            System.out.println("ERR");      
            return null;      
        }
        if (largeOne.sign == largeTwo.sign){
            //DO SOMTEIN
        } else {
            //sumtin
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
     //Dividing two Large Integers 
    public LargeInteger divide(LargeInteger li){
        LargeInteger res = new LargeInteger();
        LargeInteger largeOne = new LargeInteger(this.largeInt);
        if (largeOne.sign == ZERO){
            return new LargeInteger();      }
        if (li.sign == ZERO){
            System.out.println("ERR");      
            return null;     
        }
        if (largeOne.sign == li.sign){
            //DO SOMTEIN
        } else {
            //sumtin
        }
        LargeInteger result = new LargeInteger(res, res.sign);
        return result;
    }
    
    public boolean equals(LargeInteger li){
        if(li.length() == this.largeInt.length){
            for (int i = 0; i < li.length(); i++){
                if (li.charAt(i) != this.largeInt[i]){
                    return false;
                }
            }
        return true;    
        }
        return false;
    }
    
    /**
     * @return the largeInt
     */
    public char[] getLargeInt() {
        return largeInt;
    }
    // Returns the value of value
    public int getValue(){
        return value;
    }
    // Returns the value of value
    public int getSign(){
        return value;
    }
    //Sets the value of value
    public void setSign(int sign){
        this.sign = sign;
    }
    //Sets the value of value
    public void setValue(int value){
        this.value = value;
    }
    /**
     * @param largeInt the largeInt to set
     */
    public void setLargeInt(char[] largeInt) {
        this.setSign(0);
        if (largeInt[0] == NEGATION){
            this.sign = NEG;
            if (largeInt.length > MAX_DIGITS + 1){
            throw new IllegalArgumentException("Number too Large for Large Integer storage");
            }
        } else if (largeInt[0] >= '1' || largeInt.length > 1){
            this.sign = POS;
            if (largeInt.length > MAX_DIGITS){
                throw new IllegalArgumentException("Number too Large for Large Integer storage");
            }
        }
        this.largeInt = largeInt;
    }
    
    // Prints the Large Integer value
    public String toString(){
        String value = new String(largeInt);
        value = value.trim();
        return value;
    }
    
    public static void main(String[] args) {
      // Test constructor and toString()
      LargeInteger large0 = new LargeInteger();   
      LargeInteger largeStr = new LargeInteger("-1122");
      LargeInteger largeLong = new LargeInteger(922337203685477580L);
      LargeInteger largeLarge = new LargeInteger(largeLong);
      LargeInteger largeStr2 = new LargeInteger("10009");
      System.out.println(large0);
      System.out.println(largeStr);
      System.out.println(largeLong);
      System.out.println(largeLarge);
      
      // Adding a Large Integer and a String
      System.out.println(largeStr.add("-111"));
      System.out.println(largeStr.add("49"));
      // Adding a Large Integer and a Long
      System.out.println(largeStr.add(90L));
      // Adding two Large Integers
     System.out.println(largeLong.add(largeLong));
      
       //Subtracting a Large Integer and a String
      System.out.println(largeStr.subtract("322"));
      
        System.out.println(largeLarge.equals(large0));
        System.out.println(largeLarge.equals(largeLarge));
      
      // Checks if parameter has been altered
      System.out.println(largeStr);
 
   }
}
