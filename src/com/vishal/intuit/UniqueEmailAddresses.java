package com.vishal.intuit;

import java.util.HashSet;

public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        HashSet<String> uniqueEmails = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < emails.length; i++){
            String email = emails[i];
            String[] emailParts = email.split("@");
            //validate email host
            String emailHost = emailParts[0];
            for(int j = 0; j < emailHost.length(); j++){
                char ch = emailHost.charAt(j);
                if(ch == '.'){
                    continue;
                }else if(ch == '+'){
                    break;
                }else{
                    sb.append(ch);
                }
            }
            //validate email domain
            String emailDomain = emailParts[1];
            uniqueEmails.add(sb.append("@").append(emailDomain).toString());
            sb.setLength(0);
        }
        return uniqueEmails.size();
    }

}
