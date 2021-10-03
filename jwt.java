Method #1
import java.util.Base64;
import io.jsonwebtoken.Jwts;  
import io.jsonwebtoken.SignatureAlgorithm; 
public class JWT {
    public static void main(String[] args) {
        try {
            String secretkey="-----BEGIN PRIVATE 
KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCCSUAXd0kc6OrL\na+MzzCLYI2NhWdXq/mQzamBzpxOwDdl6Ck2sqVtcjdrmvolP5XzlKHMhU0O1tHGs\nqCCNCLkF1do1xkry7FPNuEDPH6HbEB6Z/1d6xftJymYC4nJe23V24c0hUdY/ERtY\nfYdEfF73TwdEvx4CXoTlfvHfFFFyfOEZGjBsaUbiB+GgY8eveIaGO0v7UeU7y/oc\nrscN00GaPnUra0a+7j6IX2kbtnf+OZm9dS/F74/stqvIWV65u4ZQqbAuMgQEzan3\njeCVp3SYaeShtdrJl/OzkcBdzB1Cn+53cKJ88pt5RzPGKHBEWZ1eLuP40vU1XT7f\nwgDR9nyDAgMBAAECggEAQMSxe/js+9Y+gwoLVQCygch16zuBwOTeY0EK2fPBMdBw\nwN7GZoN6y7QpknQ+Rt3LDRDiyzpdesNNj4u1QueHM4NwizMcp08dCjQC4/TRvdlx\nnRT3JC2wEqrvs5dnTAjFiGgQVfQdEhUrBv7AdCdv/nnnHyHzhTH/1ycYjtHG+6am\nGl2sbYxm56JIk5AREV2N9NDyk9215fykG6JDifjQWtsT6G8vCPcnN9T4RDm5fpnG\nhOKn0/OADPHK9MDy4y7rIoIt6PNMX/40Boe0dgE97zBFgI/OuPnItsiFwxJMcuHG\nze8dxJiEVzk7+I+RHDHjMdo6CwvVixaD08/WeAERQQKBgQDpevIXBbTnDYs/lizG\nTGh7r7nXpWPok8xcO58v1d4/BUsN4SNayYvEoVbPVWEI4EbWWLDBm6K2WuGH2jyX\nsR4jIsB2bXk1WgRZR5ZMzofEEjORz9TSuilSa8Hffg56HkA7RVe57niJnWbJSyIc\nM9p5yK+zZxg1t+7RT9vTI2v8KwKBgQCO2kDQHJ3l6VjlIQ9FxKIauRhzUtDWUEm2\nhLMxKZc0JmowOmJj5T5kia8eJl6A/4+XfviRULac59fIAgIws4zWPAtbC1wDuiKz\n8EaR0NKHUNOASwBPbrGIKclOIQVlf3kNDqkE0I6OEtX8xk3RuYlr6D3g2hlJKct4\nYyUdjy1dCQKBgAjU5LloNtqSkZTbKmBp3X3oPMBiei/+/zjx7GiTz29U1Oz2ei7h\n9s5+R9lZ4mzChwtumWkJaRM6xtMrtyUJxxkPJHaWV4JkIEv8QDwxh8Mr6RV35hX+\ngreiadf5XbTS1h0n11SqJ5cVBCFTHTwx3e7DX5oKqUjG51q1iZwn99q3AoGAN4Wc\nq0Z0GGgZpPS0eulyF/DZD/mgMawC+m2ZOAJyQlKr8xK+KxVuqqTY617+XCT4Kmmv\nMsusLk/uDk65izQ+CQZNY5WGrewqkMVSqFoBeZZwneyIslbTqZiUJUmwT0K8Sdbo\n2nY08gNgKF7q4Bi80LPzWPFr4oPcEW53foWnnAECgYBlaXNQryFOL0htf/s5NJAZ\nmrIRB+aWdoSveNm9WwG0H3JZHqCJi7puLu0J7Cu3pVbNmrfgK6BmoPCsOaX4Dz7j\nBkrtbf43E3/+5GVEWT0sWYftwDGrRbs5RfLSFl1TmA8R2bT5NgUBtpySZDiqnIHs\nOpr15NbnsD+GIr3aGmx7bg==\n-----END PRIVATE KEY----";
            byte[] decodedSecret = Base64.getDecoder().decode(secretkey);
            String jwtToken = Jwts.builder()
                .setSubject("admin")
                .setAudience("Solr")
                .signWith(SignatureAlgorithm.HS256,decodedSecret).compact();
            System.out.println("jwtToken=");
            System.out.println(jwtToken);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}


Method #2  using simple Header, Payload, private key from google docs
11:55
import java.util.Base64;
private static final String JWT_HEADER = "{\"alg\":\"HS256\",\"typ\":\"JWT\"}";
private static String JWT_HEADER.encode(byte[] bytes) {
    return Base64.getUrlEncoder().withoutPadding().encodeToString(bytes);
}
string private_key="-----BEGIN PRIVATE 
KEY-----\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCCSUAXd0kc6OrL\na+MzzCLYI2NhWdXq/mQzamBzpxOwDdl6Ck2sqVtcjdrmvolP5XzlKHMhU0O1tHGs\nqCCNCLkF1do1xkry7FPNuEDPH6HbEB6Z/1d6xftJymYC4nJe23V24c0hUdY/ERtY\nfYdEfF73TwdEvx4CXoTlfvHfFFFyfOEZGjBsaUbiB+GgY8eveIaGO0v7UeU7y/oc\nrscN00GaPnUra0a+7j6IX2kbtnf+OZm9dS/F74/stqvIWV65u4ZQqbAuMgQEzan3\njeCVp3SYaeShtdrJl/OzkcBdzB1Cn+53cKJ88pt5RzPGKHBEWZ1eLuP40vU1XT7f\nwgDR9nyDAgMBAAECggEAQMSxe/js+9Y+gwoLVQCygch16zuBwOTeY0EK2fPBMdBw\nwN7GZoN6y7QpknQ+Rt3LDRDiyzpdesNNj4u1QueHM4NwizMcp08dCjQC4/TRvdlx\nnRT3JC2wEqrvs5dnTAjFiGgQVfQdEhUrBv7AdCdv/nnnHyHzhTH/1ycYjtHG+6am\nGl2sbYxm56JIk5AREV2N9NDyk9215fykG6JDifjQWtsT6G8vCPcnN9T4RDm5fpnG\nhOKn0/OADPHK9MDy4y7rIoIt6PNMX/40Boe0dgE97zBFgI/OuPnItsiFwxJMcuHG\nze8dxJiEVzk7+I+RHDHjMdo6CwvVixaD08/WeAERQQKBgQDpevIXBbTnDYs/lizG\nTGh7r7nXpWPok8xcO58v1d4/BUsN4SNayYvEoVbPVWEI4EbWWLDBm6K2WuGH2jyX\nsR4jIsB2bXk1WgRZR5ZMzofEEjORz9TSuilSa8Hffg56HkA7RVe57niJnWbJSyIc\nM9p5yK+zZxg1t+7RT9vTI2v8KwKBgQCO2kDQHJ3l6VjlIQ9FxKIauRhzUtDWUEm2\nhLMxKZc0JmowOmJj5T5kia8eJl6A/4+XfviRULac59fIAgIws4zWPAtbC1wDuiKz\n8EaR0NKHUNOASwBPbrGIKclOIQVlf3kNDqkE0I6OEtX8xk3RuYlr6D3g2hlJKct4\nYyUdjy1dCQKBgAjU5LloNtqSkZTbKmBp3X3oPMBiei/+/zjx7GiTz29U1Oz2ei7h\n9s5+R9lZ4mzChwtumWkJaRM6xtMrtyUJxxkPJHaWV4JkIEv8QDwxh8Mr6RV35hX+\ngreiadf5XbTS1h0n11SqJ5cVBCFTHTwx3e7DX5oKqUjG51q1iZwn99q3AoGAN4Wc\nq0Z0GGgZpPS0eulyF/DZD/mgMawC+m2ZOAJyQlKr8xK+KxVuqqTY617+XCT4Kmmv\nMsusLk/uDk65izQ+CQZNY5WGrewqkMVSqFoBeZZwneyIslbTqZiUJUmwT0K8Sdbo\n2nY08gNgKF7q4Bi80LPzWPFr4oPcEW53foWnnAECgYBlaXNQryFOL0htf/s5NJAZ\nmrIRB+aWdoSveNm9WwG0H3JZHqCJi7puLu0J7Cu3pVbNmrfgK6BmoPCsOaX4Dz7j\nBkrtbf43E3/+5GVEWT0sWYftwDGrRbs5RfLSFl1TmA8R2bT5NgUBtpySZDiqnIHs\nOpr15NbnsD+GIr3aGmx7bg==\n-----END PRIVATE KEY----"
private JSONObject payload = new JSONObject();
payload.put("sub", sub);
payload.put("aud", aud);
payload.put("exp", expires);
signature = hmacSha256(encodedHeader + "." + encode(payload)+ "."+private_key);
11:56
i.e. without using jjwt


Send a message to Divya S
















