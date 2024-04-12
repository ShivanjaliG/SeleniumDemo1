

public class AustralianTrafic implements CentralTraffic 
{

public static void main(String[] args) {
// TODO Auto-generated method stub
CentralTraffic a= new AustralianTrafic();
a.redStop();
a.FlashYellow();
a.greenGo();

AustralianTrafic at=new AustralianTrafic();

at.walkonsymbol();



}

@Override
public void redStop() {

System.out.println(" redstop implementation");
}
public void walkonsymbol()
{
System.out.println("walking");
}
@Override
public void FlashYellow() {

System.out.println(" flash yellow implementation");

}

@Override
public void greenGo() {

System.out.println(" Green go implementation");
}



}


