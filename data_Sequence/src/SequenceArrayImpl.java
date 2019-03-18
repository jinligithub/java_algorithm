import java.util.Arrays;

public class SequenceArrayImpl implements Sequence {
    private static final int DEFAULT_CAPACITY=10;
    private  int size;
    private Object[] elementData;
    private  static  final int MAX_ARRAY_SIZE=Integer.MAX_VALUE-8;

    //初始化数组大小
    public SequenceArrayImpl(){
        this.elementData=new Object[DEFAULT_CAPACITY];
    }

    @Override
    public void add(Object data) {
        //容量加一
        ensureCapacity(size++);
        //赋值
        elementData[size++]=data;
    }

    @Override
    public Object remove(int index) {
        //检查容量
        rangeCheck(index);
        Object oldData=elementData[index];
        //移动元素的次数
        int moveSize=size-index-1;
        if(moveSize>0){
            System.arraycopy(elementData,index+1,elementData,index,moveSize);
        }
        elementData[--size]=null;
        return oldData;
    }
    //修改数据
    @Override
    public Object set(int index, Object newData) {
        rangeCheck(index);
        Object oldData = elementData[index];
        elementData[index]=newData;
        return oldData;
    }
    //获取值
    @Override
    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }
    //该元素是否在顺序表中存在
    @Override
    public boolean contains(Object data) {
        //如果元素为空，在顺序表中寻找是否有空元素存在
        if(data==null){
            for(int i=0;i<size;i++){
                if(elementData[i]==null){
                    return  true;
                }
            }
        }else{//不为空
            for(int i=0;i<size;i++){
                if(elementData[i].equals(data)){
                    return  true;
                }
            }
        }
        return false;
    }
    //取得顺序表的大小
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData,size);
    }
    //清空顺序表
    @Override
    public void clear() {
        for(int i=0;i<size;i++){
            elementData[i]=null;
        }
        this.size=0;

    }
    //检查容量
    private void ensureCapacity(int minCap){
        if(minCap-elementData.length>0){
            grow(minCap);
        }
    }
    //扩容
    private void grow(int minCap){
        int oldCap=elementData.length;
        int newCap=oldCap<<1;
        if(newCap-minCap<0){
            newCap=minCap;
        }
        if(newCap-MAX_ARRAY_SIZE>0){
            throw new ArrayIndexOutOfBoundsException("数组超过最大阈值");
        }
        elementData= Arrays.copyOf(elementData,newCap);
    }
    private void rangeCheck(int index){
        if(index>=size){
            throw  new IndexOutOfBoundsException("下标不存在");
        }
    }

}
