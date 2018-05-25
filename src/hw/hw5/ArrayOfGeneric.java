package hw.hw5;

import java.lang.reflect.Array;
import java.util.ArrayList;  
import java.util.Arrays;  
import java.util.List; 
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
  
public class ArrayOfGeneric {  
      
    @SuppressWarnings("unchecked")  
    public static void main(String[] args) {  
          
        String[] strs;  
        try {
            // the code compiles but generates a runtime error
            strs = arrayOfGenericTypeError(10);  //java.lang.ClassCastException:
        } catch(Exception e) {  
            System.out.println(e);  
        }  

        // the code runs normally
        strs = arrayOfGenericTypeOk(String.class, 4);
		
        System.out.println(Arrays.toString(strs));
		

		Base<String> base = new Base<>();
		Object[] ary = base.toArray();

		Object[] ary2 = base.toArray2();
		System.out.println(ary2);

    }  
      
    @SuppressWarnings("unchecked")  
    public static <T> T[] arrayOfGenericTypeError(int n) {  
        return (T[]) new Object[n];  // @SuppressWarnings("unchecked")
    }  
      
    @SuppressWarnings("unchecked")  
    public static <T> T[] arrayOfGenericTypeOk(Class<T> claz, int n) {  
        return (T[]) Array.newInstance(claz, n);  //    @SuppressWarnings("unchecked")
    }  
}  


class Base<T> {
	T t;
	public Class getGenericType(int index) {
        // getClass(): Returns the RUNTIME class of this object.
		Type genType = getClass().getGenericSuperclass();
		System.out.println(genType);
		if (!(genType instanceof ParameterizedType)) {
			return Object.class;
		}
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (index >= params.length || index < 0) {
			throw new RuntimeException("Index outof bounds");
		}
		if (!(params[index] instanceof Class)) {
			return Object.class;
		}
		return (Class) params[index];
	}

    /**
     * Return the generic type of class field `t`.
     * @return  the generic type of `t`
     */
	public Class getFieldGenericType(){
		try{
            // getClass(): ...
            // getDeclaredField(): ...
			Type genType = getClass().getDeclaredField("t").getClass().getGenericSuperclass();
			Class clz = (Class)((ParameterizedType) genType).getActualTypeArguments()[0];
			System.out.println(clz);
			return clz;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return Object.class;
	}

	public T[] toArray(){
		
		T[] a = (T[]) Array.newInstance(getGenericType(0), 100);
		return a;
	}
	public T[] toArray2(){
		
		T[] a = (T[]) Array.newInstance(getFieldGenericType(), 100);
		return a;
	}
}
