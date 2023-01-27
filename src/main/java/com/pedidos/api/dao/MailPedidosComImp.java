package com.pedidos.api.dao;

import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
public class MailPedidosComImp implements MailPedidosCom {
	
	private static Logger log = Logger.getLogger(MailPedidosComImp.class);
	
	@Autowired(required=false)
	private JavaMailSender sender;

	@Autowired(required=false)
	private VelocityEngine velocity;
	
	@Override
	public boolean enviaMailPass(final Map<String, Object> lista, List<String> correos) {
		
		log.info(lista);
		final InternetAddress[] corre = new InternetAddress[correos.size()];

		try {
			for (int i = 0; i < correos.size(); i++) {
				corre[i] = new InternetAddress(correos.get(i));
			}
			MimeMessagePreparator preparator = new MimeMessagePreparator() {

				@Override
				public void prepare(MimeMessage mimeMessage) throws Exception {
					MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
					helper.setFrom("info@pedidos.com.mx");
					helper.setTo(corre);
					helper.setSubject("Reestablece tu contraseña, pedidos.com");
					@SuppressWarnings("deprecation")
					String html = VelocityEngineUtils.mergeTemplateIntoString(velocity, "main/java/com/pedidos/api/correos/mailcontrasena.mv", lista);
					helper.setText(html, true);
				}
			};
			this.sender.send(preparator);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
}
