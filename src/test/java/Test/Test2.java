package Test;


import com.githup.mybatis.pojo.User;
import com.githup.mybatis.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class Test2 {
	public static void main(String[] args) {
		try {
			SqlSession sqlSession = SqlSessionUtil.getSqlSession();
			//执行配置文件中 的SQL语句  填 命名空间.方法名
			int count = sqlSession.selectOne("userMapper.findCountUser");
			//执行查询用户的操作  获取list类型的列表
			List<User> selectList = sqlSession.selectList("userMapper.findUser");
			System.out.println("超市会员总共有"+count);
			for (User user : selectList) {
				System.out.println(user);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}

