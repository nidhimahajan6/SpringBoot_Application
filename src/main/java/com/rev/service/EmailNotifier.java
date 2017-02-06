package com.rev.service;

import com.rev.dto.EmailDTO;
import com.rev.utility.MailStatus;

public interface EmailNotifier {

	public MailStatus sendMail(EmailDTO emailDTO,final String msg);
}
