
package returninganoptional;
import java.util.Optional;
// Returning An Optional.
// Optional type is the way to Express "we dont know" or "Not Applicable" in Java.It is created using factory in Java.we can creat empty Optional
//  or pass a value for Optional to wrap.
public class ReturningAnOptional {

    public static void main(String[] args) {
        System.out.println(average(95,100));
        System.out.println(average());
        System.out.println("----------------------------------------");
        Optional<Double> opt=average(95,100);
        if(opt.isPresent())
        System.out.println(opt.get());
        System.out.println("----------------Null Pointer Exception:------------------------");
        Optional<Double> opt1=average();// If we will not make a check by using ifPresent().
       // System.out.println(opt1.get()); this will throw Exception "NoSuchElementException" as Optional has no value:
        System.out.println("------------------------------------------");
        System.out.println(average1(null)); // Applying check for Null. Optional can control Null by using Nullable.
        System.out.println(average1(95,100));
        System.out.println("----Method Using Instead Of an IF Statement-----------------------");
        Optional<Double> optt=average(95,100);
        optt.ifPresent(System.out:: println);// we want something done if somthing is present .
        // what if nothing is present.
        Optional<Double> optt1=average();// If Nothing will be Present then orElse methods will work .
        System.out.println(optt1.orElse(Double.NaN ));//we can generate anything here.watevr we want to generate.
        System.out.println(optt1.orElseGet(()-> Math.random()));
      //System.out.println(optt1.orElseThrow(()-> new IllegalStateException())); this method will through an Exception
        
        //One thing to Note here is that Stack Trace looks wierd because Lambdas are generated instead of named Classes.
        System.out.println("--------What if we use ofElse Methods when values are present in above mentioned Example-----");
        Optional<Double> optt2=average(95,100);
        //These three statements will not even Execute.
        System.out.println(optt2.orElse(Double.NaN ));//we can generate anything here.watevr we want to generate.
        System.out.println(optt2.orElseGet(()-> Math.random()));
        System.out.println(optt2.orElseThrow(()-> new IllegalStateException()));
        
    }
    public static Optional<Double> average(Integer...scores){//Method of type Optional for finding Average.
        if(scores.length==0)
            return Optional.empty();
        int sum=0;
        for(int score: scores)
            sum += score;
        return Optional.of((double)sum /scores.length);
        
    }
    public static Optional<Double> average1(Integer...scores){
            int sum=0;
            Optional k=Optional.ofNullable(scores);// This a check for null 
            if(k.isPresent()){
                for(int score : scores)
                sum +=score;
                Optional<Double> j= Optional.of((double)sum/ scores.length);
                return j;
            }
            else
                return k;
    }
    
}
