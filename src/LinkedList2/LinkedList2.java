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
        Node _fromHead = this.head;
        while (_fromHead != null) {
            if (_fromHead.value == _value) {
                nodes.add(_fromHead);
            }
            _fromHead = _fromHead.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node _fromHead = this.head;
        Node _fromTail = this.tail;
        if (this.count == 0) {
            return false;
        }
        if (_fromHead.value == _value && this.count == 1) {
            this.clear();
            return true;
        }

        int iterCount = 0;

        while (iterCount < this.count / 2) {
            if (_fromHead.value == _value) {
                if (_fromHead == this.head) {
                    this.head = _fromHead.next;
                    _fromHead.next.prev = null;
                    count--;
                    return true;
                }
                Node prev = _fromHead.prev;
                Node next = _fromHead.next;
                prev.next = next;
                next.prev = prev;
                this.count--;
                return true;
            }
            if (_fromTail.value == _value) {
                if (_fromTail == this.tail) {
                    this.tail = _fromTail.prev;
                    _fromTail.prev.next = null;
                    this.count--;
                    return true;
                }
                Node prev = _fromTail.prev;
                Node next = _fromTail.next;
                prev.next = next;
                next.prev = prev;
                this.count--;
                return true;
            }
            _fromHead = _fromHead.next;
            _fromTail = _fromTail.prev;
            iterCount++;
        }
        if (this.count % 2 != 0){
            _fromHead = _fromHead.next;
            if (_fromHead.value == _value) {
                Node prev = _fromHead.prev;
                Node next = _fromHead.next;
                prev.next = next;
                next.prev = prev;
                this.count--;
                return true;
            }
        }
        return false;
    }

    public void removeAll(int _value) {
        Node _fromHead = this.head;
        while (_fromHead != null) {
            if (_fromHead.value == _value) {
                if (this.count == 1) {
                    this.head = null;
                    this.tail = null;
                    this.count = 0;
                    return;
                } else if (this.head == _fromHead) {
                    this.head = _fromHead.next;
                    _fromHead.next.prev = null;
                } else {
                    _fromHead.prev.next = _fromHead.next;
                    try {
                        _fromHead.next.prev = _fromHead.prev;
                    } catch (NullPointerException e) {
                        this.tail = _fromHead.prev;
                    }
                }
                this.count--;
            }
            _fromHead = _fromHead.next;
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
        Node _fromHead = this.head;
        Node _fromTail = this.tail;
        if (_nodeAfter == null) {
            this.addInTail(_nodeToInsert);
            return;
        }
        if (this.count == 1 && _fromHead == _nodeAfter) {
            this.addInTail(_nodeToInsert);
            return;
        }
        int iterCounter = 0;
        while (iterCounter < this.count / 2) {
            if (_fromHead == _nodeAfter) {
                Node swap = _fromHead.next;
                _fromHead.next = _nodeToInsert;
                _nodeToInsert.prev = _fromHead;
                _nodeToInsert.next = swap;
                swap.prev = _nodeToInsert;
                return;
            }
            if (_fromTail == _nodeAfter) {
               if (_fromTail.next == null) {
                  addInTail(_nodeToInsert);
               } else {
                   Node swap = _fromTail.next;
                   _fromTail.next = _nodeToInsert;
                   _nodeToInsert.prev = _fromTail;
                   _nodeToInsert.next = swap;
                   swap.prev = _nodeToInsert;
                   return;
               }
            }
            _fromHead = _fromHead.next;
            _fromTail = _fromTail.prev;
            this.count++;
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