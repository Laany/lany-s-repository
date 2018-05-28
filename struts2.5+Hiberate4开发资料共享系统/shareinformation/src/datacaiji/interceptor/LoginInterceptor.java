package datacaiji.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import datacaiji.bean.User;

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		if (!arg0.getProxy().getMethod().equals("login")) {
			ActionContext context = arg0.getInvocationContext();
			Map<String, Object> session = context.getSession();
			User user = (User)session.get("user");
			if (user == null) {
				return Action.LOGIN;//login对应拦截器里的login
			}
		}
		return arg0.invoke();
	}
}
