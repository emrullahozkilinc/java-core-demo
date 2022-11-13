package core_java;

import lombok.Builder;

class Main{
    public static void main(String[] args) throws CloneNotSupportedException {
        Money m1 = Money.builder().amount(20).currencyCode("TRY").build();
        Money m2 = Money.builder().amount(20).currencyCode("TRY").build();

        System.err.println(m1.equals(m1.clone()));
    }
}

@Builder
public class Money implements Cloneable{
    int amount;
    String currencyCode;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


