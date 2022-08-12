public class LinkedList {
    public static void main(String[] args) {
        System.out.println("模拟链表！");

        DataNode dataNode1 = new DataNode(1, "first");
        DataNode dataNode2 = new DataNode(2, "second");
        DataNode dataNode3 = new DataNode(3, "third");
        DataNode dataNode4 = new DataNode(4, "forth");
        DataNode dataNode5 = new DataNode(4, "fifth");

        SingleLinkedList singleLinkedList = new SingleLinkedList();

        singleLinkedList.add(dataNode1);
        singleLinkedList.add(dataNode2);
        singleLinkedList.add(dataNode3);
        singleLinkedList.add(dataNode4);
        singleLinkedList.add(dataNode5);

        singleLinkedList.show();
        System.out.println();

        singleLinkedList.update(2,"第二");

        singleLinkedList.show();
        System.out.println();

        singleLinkedList.delete(2);
        singleLinkedList.show();
    }
}

class SingleLinkedList {
    public SingleLinkedList() {
    }

    // 首先要初始化一个头节点
    // 这个头节点不能动，因为他是整个链表的起始
    // 且头节点不存放任何数据
    private DataNode head = new DataNode(0, "头节点");

    // 添加 --- 直接添加到链尾
    // 1. 遍历找到链表最后一个元素
    // 2. 将最后一个元素的next指向待添加元素
    public void add(DataNode node) {
        // 因为头节点作为入口，不可更改变动，所以先要保存一个临时的
        DataNode temp = head;
        // 开始遍历
        while (true) {
            // 没有指向下一个元素，则认为到达尾部
            if (temp.next == null) {
                break;
            }
            // 如果没有到达尾部，将遍历值后移一位
            temp = temp.next;
        }
        // while退出时，temp即为最后一个节点
        // next定向则可完成添加
        temp.next = node;
    }

    // 添加 --- 根据编号大小添加到对应位置
    // 设定规则，链表根据从小到大的顺序排序，且除头节点外，其余节点编号均大于0
    // 如果有重复编号，则不可添加
    public void insert(DataNode node) {
        // 同样的，需要先创建临时节点，避免修改头节点
        DataNode temp = head;

        while (true) {
            if (temp.next == null) {
                // 如果下一个元素已经是空了，说明已经到了尾部
                // 且前面的所有index都比待插入的小，那么直接插链表最后一个就行
                add(node);
                break;
            } else if (temp.next.index > node.index) {
                // 如果到这里，说明temp的下一个节点编号首次比待插入节点的index大
                // 此时，待插入节点应该插入temp的后面
                // 因为temp编号小，temp.next编号大
                node.next = temp.next;
                temp.next = node;
                // 至此完成添加
                break;
            } else if (temp.next.index == node.index) {
                throw new RuntimeException("当前编号已经存在！不可添加！");
            }
            temp = temp.next;
        }
    }

    // 修改链表中的数据
    // 根据编号遍历确定需要修改的元素
    // 重点不在怎么查找，所以暴力遍历
    public void update(int index,String update) {
        DataNode temp = head;
        while (true) {
            if (temp.index != index) {
                temp = temp.next;
                continue;
            }
            if (temp.next == null) {
                // 到链表尾部都没找到，就没有这个元素
                throw new RuntimeException("查无此数据！");
            }
            temp.data = update;
            break;
        }
    }

    // 删除指定元素
    // 假定利用索引查找待删除元素
    public void delete(int index){
        DataNode temp = head;
        while (true){
            if (temp.next == null){
                throw new RuntimeException("链表中无待删除元素！");
            }
            // 需要注意的是，单链表，如果让temp直接查找到要删除的元素，就无法追踪到上一个元素
            // 这就意味着链要断了
            if (temp.next.index != index){
                temp = temp.next;
                continue;
            }
            // 略过中间待删除的元素即可将其从链上删除
            // 中间元素被删除后因为没有被引用，将被垃圾回收
            temp.next = temp.next.next;
            break;
        }
    }

    // 显示链表中的所有数据
    public void show() {
        DataNode temp = head;
        while (true) {
            if (temp.index == 0) {
                System.out.print("head");
                temp = temp.next;
                continue;
            }
            System.out.print(" -> " + temp.data);
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
    }
}

//创建节点对象
class DataNode {
    public int index;
    public String data;
    public DataNode next;

    public DataNode(int index, String data) {
        this.index = index;
        this.data = data;
    }
}