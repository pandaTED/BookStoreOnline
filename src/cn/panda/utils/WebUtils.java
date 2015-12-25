package cn.panda.utils;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.panda.domain.book.Book;
import cn.panda.domain.category.Category;
import cn.panda.service.BussinessService;
import cn.panda.service.impl.BussinessServiceImpl;

public class WebUtils {

	public static <T> T request2Bean(HttpServletRequest request,
			Class<T> beanClass) {
		try {
			T bean = beanClass.newInstance();
			Map map = request.getParameterMap();
			BeanUtils.populate(bean, map);
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static Book upload(HttpServletRequest request, String uploadPath) {
		try {
			Book book = new Book();

			DiskFileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding(request.getCharacterEncoding());
			List<FileItem> list = upload.parseRequest(request);
			for (FileItem item : list) {
				if (item.isFormField()) {
					String inputName = item.getFieldName();
					String value = item.getString("UTF-8");
					if ("category_id".equals(inputName)) {
						BussinessService service = new BussinessServiceImpl();
						Category c = service.findCategory(value);
						book.setCategory(c);
					} else {
						BeanUtils.setProperty(book, inputName, value);
					}
				} else {
					String filename = item.getName();
					filename = filename
							.substring(filename.lastIndexOf("\\") + 1);
					String savepath = uploadPath;
					String saveFilename = UUID.randomUUID().toString()
							+ filename;

					InputStream in = item.getInputStream();
					FileOutputStream out = new FileOutputStream(savepath + "\\"
							+ saveFilename);
					int len = 0;
					byte buffer[] = new byte[1024];
					while ((len = in.read(buffer)) > 0) {
						out.write(buffer, 0, len);
					}
					in.close();
					out.close();
					item.delete();
					book.setImage(saveFilename);
				}
			}
			book.setId(UUID.randomUUID().toString());
			return book;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
