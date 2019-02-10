import java.util.*;


public class HashMapDemo {
    public static void scandemo()
    {
        Map<String,String> map=new HashMap<String,String>();
        Scanner console=new Scanner(System.in);
        System.out.println("请输入3组英文和中文解释:");
        int i=0;
        while(i<3)
        {
            System.out.println("请输入英文：");
            String s1=console.next();
            System.out.println("请输入中文：");
            String s2=console.next();
            map.put(s1,s2);
            i++;
        }

    }
    public static void main(String[] args) {
        {
            class bijiao implements Comparator<String>{
                @Override
                public int compare(String s1,String s2)
                {
                    if (s1.equals(s2))
                        return 0;//字符串重复时不保存
                    return 1;//正数时顺序存储，负数时反序存储
                }
            }
            TreeSet<String> ts=new TreeSet<>( new bijiao() );

            ts.add("ab");
            ts.add("ab");//重复不会保存
            ts.add("cd");
            ts.add("ad");
            ts.add("0d");
            System.out.println(ts);
            Iterator it=ts.iterator();
            while(it.hasNext())
                System.out.println(">>>"+it.next());
            int x=1;
            if(x==1) return;
        }

        {
            TreeSet<String> ts2=new TreeSet<>();
            ts2.add("ab");
            ts2.add("ab");//重复不会保存
            ts2.add("cd");
            ts2.add("ad");
            ts2.add("0d");
            System.out.println(ts2);//无序
            if(1==1) return;
        }

        {
            Person p1=new Person("4301","lb");
            Person p2=new Person("4301","lb");

            System.out.println(String.format("hascode1=%d,hascode2=%d",p1.hashCode(),p2.hashCode()));
            if(1==1)
                return;

        }
        {
            HashSet hs1 = new HashSet();
            hs1.add("01");
            hs1.add("01");//重复的不会添加
            hs1.add("02");
            hs1.add("a");
            hs1.add("A");//区别大小写，此元素会添加
            hs1.add(123);
            for (Object o : hs1)
                System.out.println(o.toString());//遍历元素
            if (1 == 1)
                return;
        }

        String hascode1="中华人民共和国";
        String hascode2="中华人民共和国";
        System.out.println(hascode1.hashCode());
        System.out.println(hascode2.hashCode());
        Map<String,String> map=new HashMap<>();
        map.put("dog","狗子");
        map.put("cat","猫");


        Iterator<String> it=map.values().iterator();


        System.out.println("输出所有值(value)：");
        while(it.hasNext())
            System.out.println("value="+it.next());

        System.out.println("输出所有key和value:");
        Set<Map.Entry<String,String>> entrySet=map.entrySet();
        for(Map.Entry<String,String> entry:entrySet)
        {
            System.out.println( String.format("key=%s value=%s",entry.getKey(),entry.getValue()) );
        }
        System.out.println("判断包含key->dog:"+map.containsKey("dog"));
        System.out.println("判断包含key->dog2:"+map.containsKey("dog2"));
        System.out.println("判断包含value->猫:"+map.containsValue("猫"));
        System.out.println("判断包含value->牛:"+map.containsValue("牛"));

        System.out.println("remove dog:"+map.remove("dog"));//删除key->dog
        System.out.println("删除dog后");
        it=map.values().iterator();
        while(it.hasNext())
            System.out.println("value="+it.next());
        map.put("dog","新狗子");
        System.out.println(map.values());//value集合
        System.out.println(map.keySet());//key集合
        System.out.println(map.entrySet());//key&value集合

        {
            HashMap<String, Integer> map3=new HashMap<>();
            /*boolean*///删除这个键值对
            map3.put("DEMO1", 1);
            map3.put("DEMO2", 2);
            System.out.println(map3);//{DEMO1=1, DEMO2=2}
            System.out.println(map3.remove("DEMO2", 1));//false
            System.out.println(map3.remove("DEMO2", 2));//true
            System.out.println(map3);//{DEMO1=1}
        }

        {
            System.out.println("===========5===");
            HashMap<String, Integer> map5=new HashMap<>();
            /*void*///清空map
            map5.put("DEMO1", 1);
            map5.put("DEMO2", 2);
            System.out.println(map5);//{DEMO1=1, DEMO2=2}
            map5.clear();//清空
            System.out.println(map5);//{}
        }

        System.out.println("=============6=====");
        {
            HashMap<String, Integer> map6=new HashMap<>();
            /*boolean*///判断map中是否存在这个key
            map6.put("DEMO1", 1);
            map6.put("DEMO2", 2);
            System.out.println(map6);//{DEMO1=1, DEMO2=2}
            System.out.println(map6.putIfAbsent("DEMO1", 9));//返回1 ，缺少demo1才put,故没put
            System.out.println(map6.putIfAbsent("DEMO3", 9));//返回null,  缺少demo3，故putdemo3->9
            System.out.println(map6);//{DEMO1=1, DEMO2=2}
        }
    }
}


 class Person {

    //身份证
    private String idCard;

    private String name;

     public Person(String idCard, String name) {
         this.idCard = idCard;
         this.name = name;
     }

     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    //重写equals方法(规则是：idCard一致，则认为是同一个人)
    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
        if(!(obj instanceof Person)) {
            return false;
        }
        Person others = (Person) obj;
        if(others.getIdCard().equals(idCard)) {
            return true;
        }
        return false;
    }

     @Override
     public int hashCode() {
         return this.idCard.hashCode()+this.name.hashCode();
     }
 }