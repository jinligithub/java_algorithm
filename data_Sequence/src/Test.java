public class Test {
    public static void main(String[] args) {
        Sequence sequence = new SequenceImpl();
        sequence.add(1);
        sequence.add(2);
        sequence.add(3);
        sequence.add(4);
        ((SequenceImpl)sequence).add(2,666);
        Object[] datas=sequence.toArray();
        for(Object o:datas){
            System.out.print(o+",");
        }
//        System.out.println(sequence.size());
//        System.out.println(sequence.get(1));
//        System.out.println(sequence.set(1,20));
//        System.out.println();
        sequence.remove(2);
        System.out.println('\n');
        datas=sequence.toArray();
        for(Object o:datas){
            System.out.print(o+",");
        }
    }

}
