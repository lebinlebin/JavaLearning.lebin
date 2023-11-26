package Java.lebin.Training.DSA._02_LinkedList;

/**
 * AbstractList
 * 抽象类，保持继承该类的子类不必要全部实现其中的方法
 * 接口interface 继承接口必须实现所有的接口方法
 * @param <E>
 */
public abstract class AbstractList<E> implements List<E>  {
	/**
	 * 元素的数量
	 */
	protected int size;
	/**
	 * 元素的数量
	 * @return
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * 是否为空
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		 return size == 0;
	}

	/**
	 * 是否包含某个元素
	 * @param element
	 * @return
	 */
	@Override
	public boolean contains(E element) {
		return indexOf(element) != ELEMENT_NOT_FOUND;
	}

	/**
	 * 添加元素到尾部
	 * @param element
	 */
	@Override
	public void add(E element) {
		add(size, element);
	}
	
	protected void outOfBounds(int index) {
		throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
	}

	//下标检查
	protected void rangeCheck(int index) {
		if (index < 0 || index >= size) {
			outOfBounds(index);
		}
	}
	//下标检查
	protected void rangeCheckForAdd(int index) {
		if (index < 0 || index > size) {
			outOfBounds(index);
		}
	}
}
