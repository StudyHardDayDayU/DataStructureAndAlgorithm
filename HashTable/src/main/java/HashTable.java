import java.util.Scanner;

public class HashTable {
    public static void main(String[] args) {
        System.out.println("哈希表");

        // 创建hash表
        hashTab hashtab = new hashTab(7);

        // 写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:添加雇员");
            System.out.println("list:展示所有雇员");
            System.out.println("find:查找雇员");
            System.out.println("exit:退出");

            key = scanner.next();

            switch (key) {
                case "add":
                    System.out.println("输入ID");
                    int id = scanner.nextInt();
                    System.out.println("输入姓名");
                    String name = scanner.next();
                    // 创建雇员
                    Emp emp = new Emp(id, name);
                    hashtab.add(emp);
                    break;

                case "list":
                    hashtab.list();
                    break;
                case "find":
                    System.out.println("请输入需要查找的ID");
                    id = scanner.nextInt();
                    hashtab.searchById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class hashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size; // 表示有多少条链表

    // 构造器
    public hashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        // 初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    // 散列函数
    public int hash(int id) {
        return id % size;
    }

    // 添加雇员
    public void add(Emp emp) {
        empLinkedLists[hash(emp.id)].add(emp);
    }

    // 遍历链表
    public void list() {
        for (int i = 0; i < empLinkedLists.length; i++) {
            empLinkedLists[i].list(i);
        }
    }

    // 根据ID查找雇员
    public void searchById(int id) {
        // 要查找的ID对应哪儿一个链表
        int index = hash(id);
        // 调用查找函数
        Emp emp = empLinkedLists[index].searchById(id);
        // 那么找没找到呢
        if (emp == null ){
            System.out.println("表中未存储此雇员的信息");
            return;
        } else {
            System.out.println("ID:" + emp.id + " name:" + emp.name);
        }
    }
}

/**
 * 表示一个雇员
 */
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

/**
 * 封装链表类
 */
class EmpLinkedList {
    // 头指针，直接指向第一个Emp
    private Emp head;

    // 添加雇员到链表
    public void add(Emp emp) {
        // 如果添加的是第一个成员
        if (head == null) {
            head = emp;
            return;
        }
        // 如果不是第一个雇员
        // 创建一个辅助节点，因为头节点是不能动的
        Emp current = head;
        while (true) {
            if (current.next == null) {
                break;
            }
            current = current.next;
        }
        current.next = emp;
    }

    // 遍历链表
    public void list(int no) {
        // 如果当前链表为空
        if (head == null) {
            System.out.println("第" + (no + 1) + "链表为空！");
            return;
        }
        System.out.println("第" + (no + 1) + "链表内容为：");
        // 创建一个辅助节点，因为头节点是不能动的
        Emp current = head;

        while (true) {
            // 这是为了避免重复打印
            if (current == head) {
                System.out.print("ID: " + current.id + ",name: " + current.name + " ");
            }

            // 如果已经找到了最后一个
            if (current.next == null) {
                break;
            }
            System.out.print("--> " + "ID:" + current.id + ",name:" + current.name + " ");
            current = current.next;
        }

        System.out.println("");
    }

    // 根据ID查找雇员信息
    public Emp searchById(int id) {
        // 查看是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        // 创建辅助指针
        Emp current = head;

        while (true) {
            if (current.id == id) {
                break;
            }
            if (current.next == null) {
                current = null;
                break;
            }
            current = current.next;
        }

        return current;
    }
}