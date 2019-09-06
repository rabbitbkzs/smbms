package Test;


import com.githup.mybatis.dao.UserMapper;
import com.githup.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Test {
	public static void main(String[] args) {
		SqlSession sqlSession=null;
		try {
			//1.获取sqlSession对象
			sqlSession	= SqlSessionUtil.getSqlSession();
			//2.通过sqlSession获取userMappen的对象
			UserMapper userMapper= sqlSession.getMapper(UserMapper.class);
			//3.通过userMapper来执行各种操作
			//List<User> userList= userMapper.findUser();
			//通过名字来模糊查询用户
//			User user = userMapper.findUserByUserName("喜");
			//1.使用对象来传参数
//			User user= new User();
//			user.setUserName("喜");
//			user.setUserRole(2);
//			user = userMapper.findUserByUserNameAndUserRole(user);

			//2.多个参数使用map集合来传递参数
//			HashMap<String,Object> map =new HashMap<>();
//			map.put("userName","喜");
//			map.put("userRole",2);
//			User user	=userMapper.findUserByMap(map);
			//3.多个参数
//			//* 如果2个参数以内包含2个参数,推荐用注解传参	以上的推荐对象来传 不在一个对象里面的参数用map集合来传
//			User user = userMapper.findUserByUserNameAndUserRole1("龙",2);

			//4.使用resultMap 进行字段的映射
//			User user =userMapper.findUserByUserNameAndUserRole2("龙",2);
//			System.out.println(user);
			//5.增加一条用户信息
			//只要是涉及到增删改查操作mybatis都要开启事物
			Logger logger = Logger.getLogger(Test.class);
//			int row =userMapper.addUser();
//			if (row > 0){
//				System.out.println("增加成功");
//			}
			//6.修改操作  将盖逸轩改为权大庆
//			User user = new User();
//			user.setUserName("权大庆");
//			user.setUserCode("qdq");
//			user.setId(18);
//			int row = userMapper.updateUserNameAndUserCode(user);
			//7.删除操作,删除盖逸轩
			int row = userMapper.deleteUserByUserName("盖逸轩");
			if (row > 0){
				System.out.println("删除成功");
			}
			logger.debug("追踪状态信息=======>>"+row);
			//提交事务
			sqlSession.commit();
			//4.迭代userList
//			for (User user : userList) {
//				System.out.println(user);
//			}
			// sprint MVC
		} catch (IOException e) {
			e.printStackTrace();
			//出现异常回滚事物
			sqlSession.rollback();
		}

	}
}

