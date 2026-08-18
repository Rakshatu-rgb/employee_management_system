package com.tcs.ems.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tcs.ems.dto.VerifyOtpRequest;
import com.tcs.ems.entity.User;
import com.tcs.ems.exception.InvalidOtpException;
import com.tcs.ems.exception.OtpExpiredException;
import com.tcs.ems.exception.UserNotFoundException;
import com.tcs.ems.repository.UserRepository;

@Service
public class OtpService {
	
	UserRepository userRepository;
	
	public OtpService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Object verifyOtp(VerifyOtpRequest verifyOtpRequest) {
		Optional<User> optionaluser=userRepository.findByEmail(verifyOtpRequest.getEmail());
		if(optionaluser.isPresent()) {
			User user = optionaluser.get();
			if(user.getOtp()==null) {
				throw new InvalidOtpException("otp already used or generated");
			}
			if(!user.getOtp().equals(verifyOtpRequest.getOtp())) {
				throw new InvalidOtpException("Invalid otp");
			}
			if(LocalDateTime.now().isAfter(user.getOtpexpirytime())){
				throw new OtpExpiredException("Your otp is expired");
			}else {
				user.setVerified(true);
				user.setOtp(null);
				user.setOtpexpirytime(null);
				return userRepository.save(user);
			}
		}else {
			throw new UserNotFoundException("User not found");
		}
	}
	
}
