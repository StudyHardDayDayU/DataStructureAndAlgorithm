import java.util.Scanner;

public class CircleArrayQueue {
    public static void main(String[] args) {
        System.out.println("利用数组模拟一个环形数组");

        Scanner scanner = new Scanner(System.in);

        System.out.println("请设置队列的长度！");
        int size = scanner.nextInt();
        Queue queue = new Queue(size);



        while (true) {
            System.out.println("Type a to add data into the queue");
            System.out.println("Type g to get data from the queue");
            System.out.println("Type s to show all of the data in the queue");
            System.out.println("Type h to show head data of the queue");
            System.out.println("请输入指令操作队列");

            char key = scanner.next().charAt(0);
            switch (key) {
                case 'a': {
                    System.out.println("请输入需要添加到队列的数据");
                    int input = scanner.nextInt();
                    queue.add(input);
                    break;
                }
                case 'g': {
                    System.out.println("获取到数据： " + queue.get());
                    break;
                }
                case 's': {
                    System.out.println("队列中的所有数据: ");
                    queue.showAll();
                    break;
                }
                case 'h': {
                    System.out.print("队列中的头数据: ");
                    queue.showHead();
                    System.out.println();
                    break;
                }
            }
        }
    }
}


class Queue {
    private int front;
    private int rear;
    private int maxSize;
    private int[] queue;

//    各个判断方法的结论条件在分析里面都有

    public Queue(int maxSize) {
//        初始化
        front = 0;
        rear = 0;
        this.maxSize = maxSize;
        queue = new int[maxSize];
    }

    // 查看队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    // 查看队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    // 添加数据到队列
    public void add(int data) {
        if (isFull()) {
            System.out.println("抱歉，队列已满，不可添加数据！");
            return;
        }
        queue[rear] = data;
        // 为什么要这么做？
        // 当front不是0，而rear要超过maxSize的时候，+1，就会超出范围
        // 如果按照环形的思路，当rear跨过尾端的时候，就应该从首端继续接上
        // 此时应该重置rear的值，但是有个更科学的算法：取模，相当于减去一个或多个maxSize。
        rear = (rear + 1) % maxSize;
    }

    // 获取数据，即出队列
    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队列存储为空！无数据可取！");
        }
        int ValueForReturn = queue[front];
        // 为什么取模？和上面一样，都是考虑到数值超出了maxSize后需要重置
        front = (front + 1) % maxSize;
        return ValueForReturn;
    }

    // 显示队列的所有元素
    public void showAll() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        for (int i = front; i < front + (rear + maxSize - front) % maxSize; i++) {
            System.out.print(queue[i] + "  ");
        }
    }

    // 显示队列的头数据
    public void showHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        System.out.print(queue[front]);
    }
}
