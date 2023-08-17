package com.vishal.amazon;


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
        String url = "stripe.com/payments/checkout/customer.maria"; //s4e.c1m/p6s/c6t/c6r.m3a
        Compression compression = new Compression();
        //System.out.println(compression.getCompressedResult(url));
        System.out.println(compression.getCompressedResult("section/how.to.write.a.java.program.in.one.day", 2));
    }

    private String getCompressedResult(String s, int m) {
        String[] domains = s.split("\\/");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < domains.length; i++){
            String[] subDomains = domains[i].split("\\.");
            int start = 1;
            int end = 0;
            for(int j = 0; j < subDomains.length; j++){
                String subDomain = subDomains[j];
                if(start < m){
                    int intValue = subDomain.length()-2;
                    sb.append(subDomain.charAt(0)).append(intValue).append(subDomain.charAt(subDomain.length()-1));
                    if(j < subDomains.length-1){
                        sb.append(".");
                    }
                }else {
                    int count = 0;
                    for(int k = j; k < subDomains.length; k++){
                        count += subDomains[k].length();
                        end = k;
                    }
                    count -= 2;
                    String lastSubDomain = subDomains[end];
                    sb.append(subDomain.charAt(0)).append(count).append(lastSubDomain.charAt(lastSubDomain.length()-1));
                    break;
                }
                start++;
            }
            if(i < domains.length-1){
                sb.append("/");
            }
        }
        return sb.toString();
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
