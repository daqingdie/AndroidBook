package cc.Book.serviceImpl;

import java.util.List;

import cc.Book.Dao.BookDao;
import cc.Book.Dao.CartDao;
import cc.Book.DaoImpl.BookDaoImpl;
import cc.Book.DaoImpl.CartDaoImpl;
import cc.Book.JavaBean.Book;
import cc.Book.JavaBean.Cart;
import cc.Book.service.CartService;

public class CartServiceImpl implements CartService {
	//创建DaoImpl对象
	CartDao ca=new CartDaoImpl();
	BookDao bo=new BookDaoImpl();

	@Override
	public void addCart(int id,String name) throws Exception {   //新增购物车
		// TODO Auto-generated method stub
		try{
			List<Book> boo=null;
			boo=bo.queryBookOfId(id);    //根据编号查询图书信息
			Book book=boo.get(0);
			int num=1;
			double sum=num*book.getBookPrice();  //计算购物车总价
			Cart cart=new Cart();
			//封装信息
			cart.setBookName(book.getBookName());
			cart.setBookPrice(book.getBookPrice());
			cart.setUserName(name);
			cart.setNumber(num);
			cart.setSum(sum);
			bo.updateBookNum(book.getBookId(), book.getBookNum()-num); //图书库存减1
			ca.insertCart(cart);        //新增购物车信息
			
			
			
		}catch(Exception e){
			
		}
		
		
	}

	@Override
	public List<Cart> seeCart(String name) throws Exception {   //查看购物车
		// TODO Auto-generated method stub
		try{
			//查询，封装，返回
			List<Cart> all=null;
			all=ca.queryCartOfUserName(name);
			return all;
			
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public void delCart(int id) throws Exception {    //删除购物车
		// TODO Auto-generated method stub
		try{
			List<Cart> carts=ca.queryCartOfId(id);    //根据id查询购物车信息
			Cart cart=carts.get(0);
			List<Book> books=bo.queryBookOfName(cart.getBookName());  //查询购物车对应的图书信息
			Book book=books.get(0);
			bo.updateBookNum(book.getBookId(), book.getBookNum()+cart.getNumber());  //修改图书库存
			ca.deleteCart(id);                     //删除购物车
			
			
		}catch(Exception e){
			
		}
		
	}

	@Override
	public List<Cart> queryCart(int id) throws Exception {          //查询购物车信息
		
		// TODO Auto-generated method stub
		try{
			//查询，封装，返回
			List<Cart> all=null;
			all=ca.queryCartOfId(id);
			return all;
			
		}catch(Exception e){
			return null;
		}
	}

	@Override
	public boolean changeCart(int id, int num) {						//修改购物车信息
		// TODO Auto-generated method stub
		try{
			List<Cart> carts=ca.queryCartOfId(id);                    //查询购物车信息
			Cart cart=carts.get(0);
			List<Book> books=bo.queryBookOfName(cart.getBookName());	//查询购物车对应的图书信息
			Book book=books.get(0);
			int newnum=book.getBookNum()-num+cart.getNumber();         //计算修改后的图书库存
			if(newnum>=0){                                            //库存是否足够
				bo.updateBookNum(book.getBookId(),newnum);			//修改图书库存
				ca.updateCartNum(id, num);							//更新购物车信息
				return true;
			}else{
				return false;
			}
			
			
		}catch(Exception e){
			return false;
		}
		
	}

	@Override
	public boolean isExist(int id,String name) {                 //购物车是否存在某本书
		try{
			List<Book> books=bo.queryBookOfId(id);				//根据编号查询图书
			List<Cart> carts=ca.queryCartOfUserName(name);		//查询该用户已有的购物车信息
			Book book=books.get(0);
			for(int i=0;i<carts.size();i++){
				if(book.getBookName().equals(carts.get(i).getBookName()))		//检查是否有匹配
					return true;								//存在该书
			}
			return false;										//不存在该书
			
		}catch(Exception e){
			
			return true;
		}
		// TODO Auto-generated method stub
		
	}

}
