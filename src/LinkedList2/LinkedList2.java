package LinkedList2;

import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;
    public int count;
    public LinkedList2() {
        count = 0;
        head = null;
        tail = null;
    }

    public void addInTail(Node _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        this.count++;
    }

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();

        Node nodeHead = this.head;
        Node nodeTail = this.tail;
        int iterCount = 0;
        while (iterCount < this.count/2+1) { // проверить
            if (nodeHead.value == _value && nodeTail.value == _value && this.count == 1) {
                nodes.add(nodeHead);
                break;
            }
            if (nodeHead.value == _value && nodeTail.value == _value) {
                nodes.add(nodeHead);
                nodes.add(nodeTail);
               break;
            } else {
                if (nodeHead != nodeTail) {
                    if (nodeHead.value == _value) {
                        nodes.add(nodeHead);
                    }
                    if (nodeTail.value == _value) {
                        nodes.add(nodeTail);
                    }
                } else {
                    if (nodeHead.value == _value) {
                        nodes.add(nodeHead);
                        break;
                    }
                }
            }

            nodeHead = nodeHead.next;
            nodeTail = nodeTail.prev;
            iterCount++;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node _fromHead = this.head;
        Node _fromTail = this.tail;
        if (_fromHead == null && _fromTail == null) {
            return false;
        }
        if (_fromHead == _fromTail && _fromHead.value == _value) {
            this.clear();
            return true;
        }

        assert _fromHead != null;
        if (_fromHead.value == _value && _fromTail.value == _value && this.count == 2) {
            this.head.prev = null;
            this.head.next = null;
            this.tail = this.head;
            return true;
        }
        if (_fromHead.value == _value && this.count >= 2) {
            this.head = this.head.next;
            this.head.prev = null;
            return true;
        }
        if (_fromTail.value == _value && this.count >= 2) {
            this.tail = this.tail.prev;
            this.tail.next = null;
            return true;
        }
        int iterCount = 0;
        while (iterCount < this.count/2+1) {
            if (_fromHead.value == _value && _fromHead == this.head) {
               this.head = _fromHead.next;
                _fromHead.next.prev = null;
                count--;
                return true;
            }
            if (_fromTail.value == _value && _fromTail == this.tail) {
                this.tail = _fromTail.prev;
                _fromTail.prev.next = null;
                count--;
                return true;
            }

            if (_fromHead.value == _value) {
                Node prev = _fromHead.prev;
                Node next = _fromHead.next;
                prev.next = next;
                next.prev = prev;
                count--;
                return true;
            }
            if (_fromTail.value == _value) {
                Node prev = _fromTail.prev;
                Node next = _fromTail.next;
                prev.next = next;
                next.prev = prev;
                count--;
                return true;
            }
            _fromHead = _fromHead.next;
            _fromTail = _fromTail.prev;
            iterCount++;
        }
        return false;
    }


    public void removeAll(int _value) {
        if (count == 0){
            return;
        }
        Node _fromHead = this.head;
        Node _fromTail = this.tail;
        int iterCount = 0;
        while (iterCount < this.count/2+1) {
            try {
                if(_fromHead.value == _value && _fromTail.value == _value){
                    remove(_value);
                }else if(_fromHead.value == _value){
                    remove(_value);
                }else if(_fromTail.value == _value){
                    remove(_value);
                }
                _fromHead = _fromHead.next;
                _fromTail = _fromTail.prev;
                iterCount++;
            } catch (NullPointerException e) {
                return;
            }
        }
    }

    public void clear() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    public int count() {
        return this.count;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            this.head = _nodeToInsert;
            this.tail = _nodeToInsert;
            count++;
        } else if(this.count == 1) {
            this.head.next= _nodeToInsert;
            _nodeToInsert.prev = this.head;
            this.tail = _nodeToInsert;
            count++;
        } else if (this.count() >= 2) {
            Node _fromHead = this.head;
            Node _fromTail = this.tail;
            int iterCount = 0;
            while (iterCount < this.count/2+1) {
                if (_fromHead == _nodeAfter) {
                    Node swap = _fromHead.next;
                    _fromHead.next = _nodeToInsert;
                    _nodeToInsert.prev = _fromHead;
                    _nodeToInsert.next = swap;
                    swap.prev = _nodeToInsert;
                    count++;
                    break;

                }
                if (_fromTail == _nodeAfter) {
                    Node swap = _fromTail.prev;
                    _fromTail.prev = _nodeToInsert;
                    _nodeToInsert.next = _fromTail;
                    _nodeToInsert.prev = swap;
                    swap.next = _nodeToInsert;
                    count++;
                    break;
                }

                _fromHead = _fromHead.next;
                _fromTail = _fromTail.prev;
                iterCount++;

            }

        }

    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}