package com.vishal.string;


/*
*
* Given a String, split it into major parts separated by special char '/'. For each major part that’s split by '/',
* we can further split it into minor parts separated by '.'.

# ### Example 1
# str = stripe.com/payments/checkout/customer.john.doe
# minor_parts = 2

# after Part 1 compression
# =>
# s4e.c1m/p6s/c6t/c6r.j2n.d1e

# after Part 2 compression
# =>
# s4e.c1m/p6s/c6t/c6r.j5e


# ### Example 2
# Given:
# str = www.api.stripe.com/checkout
# minor_parts = 3

# (after Part 1 compression)
# =>
# w1w.a1i.s4e.c1m/c6t

# (then after Part 2 compression)
# =>
# w1w.a1i.s7m/c6t
*
* */

/*
*
* stripe.com/payments/checkout/customer.john.doe
* stripe.com, payments, checkout, customer.john.doe
* s4e.c1m/p6s/c6t/c6r.j2n.d1e
* */
public class Compression {

    public static void main(String[] args) {
        String url = "stripe.com/payments/checkout/customer.john.doe";
        Compression compression = new Compression();
        System.out.println(compression.getCompressedResult(url));
    }

    private String getCompressedResult(String s){
        String[] domains = s.split("\\/");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < domains.length; i++){
            String[] subDomains = domains[i].split("\\.");
            for(int j = 0; j < subDomains.length; j++){
                int intValue = subDomains[j].length()-2;
                sb.append(subDomains[j].charAt(0)).append(intValue).append(subDomains[j].charAt(subDomains[j].length()-1));
                if(j < subDomains.length-1){
                    sb.append(".");
                }
            }
            if(i < domains.length-1){
                sb.append("/");
            }
        }
        return sb.toString();
    }

}
