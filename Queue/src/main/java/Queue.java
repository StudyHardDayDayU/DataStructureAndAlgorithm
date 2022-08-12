import java.security.Key;
import java.util.Scanner;

public class Queue {
    public static void main(String[] args) {
        System.out.println(3%5);

        ArrayQueue queue = new ArrayQueue(5);

        Scanner scanner = new Scanner(System.in);

        char key ;// 用于存放输入的指令关键字

        while (true){
            System.out.println("Type 'a' to add number into the queue");
            System.out.println("Type 's' to show all of the queue");
            System.out.println("Type 'h' to show head of the queue");
            System.out.println("Type 'g' to get data from the queue");

            key = scanner.next().charAt(0);

            switch (key) {
                case 's':{
                    queue.showAll();
                    break;
                }
                case 'a':{
                    System.out.println("请输入需要添加的数据");
                    int value = scanner.nextInt();
                    queue.add(value);
                    break;
                }
                case 'h':{
                    queue.showHead();
                    break;
                }
                case 'g':{
                    System.out.println( "取出的数据为: " + queue.get());;
                    break;
                }
            }
        }
    }
}

// 用数组模拟一个队列
class ArrayQueue {
    private int maxSize;// 最大的存储长度
    private int front;// 头部指针
    private int rear;// 尾部指针
    private int[] queue;// 模拟队列的数组

    // 构造函数，初始化最大存储量、头尾指针及queue
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        this.front = -1;
        this.rear = -1;
        this.queue = new int[maxSize];
    }

    // 判断队列是否为空
    private boolean isEmpty(){
        if (this.front == this.rear){
            return true;
        }
        return false;
    }

    // 判断队列是否为满
    private boolean isFull(){
        if (this.rear == this.maxSize-1){
            return true;
        }
        return false;
    }

    // 向队列中添加数据
    public void add(int data){
        // 先判断是不是满的
        if(this.isFull()){
            return;
        }
        // 如果不是满的，继续逻辑
        rear++;
        // 先++是因为，rear指向的是最后一个元素，如果rear后移则指向后一个空闲的位置
        queue[rear] = data;
    }

    // 从队列中获取数据
    public int get(){
        // 先判断是不是空的
        if (this.isEmpty()){
            throw new RuntimeException("队列为空，无法取出数据");
        }
        // 如果不是满的，要遵守先入先出的规则
        // 因为输入存放是从数组头部开始存放的
        // 所以取的时候要利用front取值
        front++;
        return queue[front];
    }

    // 显示队列所有数据
    public void showAll(){
        if (this.isEmpty()){
            throw new RuntimeException("队列为空，无法展示数据");
        }
        for (int data:queue){
            if (data == 0){
                break;
            }
            System.out.print(data + "  ");
        }
        System.out.println();
    }

    // 显示队列头部数据（第一个数据）
    public void showHead(){
        if (this.isEmpty()) {
            throw new RuntimeException("队列为空，无头部数据！");
        }
        System.out.println(queue[front + 1]);// front指向的是第一个数据的前一个位置
    }

    // 测试用
    public void show(){
        System.out.println(this.maxSize);
        System.out.println(this.front);
        System.out.println(this.rear);
        System.out.println(this.queue);
    }
}