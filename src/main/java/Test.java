

import com.my.User;
import com.sun.istack.internal.NotNull;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;

public class Test {
    public static void main(String[] args) {
        String s="20201232";

        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");

            sdf.setLenient(false);

            Date d=sdf.parse(s);
            System.out.println(sdf.format(d));
        } catch (ParseException e) {
            e.printStackTrace();
        }


    }

    public void a(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(1);
        list.add(1);
        Integer i=list.stream().reduce(0,Integer::sum);
        System.out.println(i);
        List<String> l=new ArrayList<>();
        List<Integer> list1=list.stream().reduce(new ArrayList<Integer>(),(List<Integer> ll,Integer ii)->{
            ll.add(ii);
            return ll;
        },(List<Integer> l2,List<Integer> e)->{
            l2.addAll(e);
            return l2;
        });
        List<User> userList=new ArrayList<>();
        User user=new User(1,"1","nan");
 userList.add(user);
//        Map<Boolean,List<User>> map=userList.stream().collect(Collectors.partitioningBy());
        userList.stream().collect(Collectors.groupingBy(User::getSex));
        userList.stream().collect(Collectors.partitioningBy(p->p.getSex().equals("1")));
        System.out.println(list1);

    }

    /**
     * sha256_HMAC加密
     * @param message 消息
     * @param secret  秘钥
     * @return 加密后字符串
     */
    public  String sha256_HMAC(String message, String secret) {
        StringBuilder hs = new StringBuilder();
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(message.getBytes());
            String stmp;
            for (int n = 0; bytes!=null && n < bytes.length; n++) {
                stmp = Integer.toHexString(bytes[n] & 0XFF);
                if (stmp.length() == 1)
                    hs.append('0');
                hs.append(stmp);
            }
        } catch (Exception e) {
            System.out.println("Error HmacSHA256 ===========" + e.getMessage());
        }
        return hs.toString();
    }
}
