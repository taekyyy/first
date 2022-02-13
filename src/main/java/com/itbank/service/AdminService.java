package com.itbank.service;

import java.io.File;
import java.io.FileInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.model.AdminDAO;
import com.itbank.model.AdminDTO;
import com.itbank.model.TravelDTO;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

@Service
public class AdminService {
	
	private final String serverIP = "221.164.9.200";
	private final int serverPort = 30022;
	private final String serverUser = "root";
	private final String serverPass = "1";
	private ChannelSftp chSftp = null;
	
	@Autowired private AdminDAO dao;
	
	public AdminDTO admin(AdminDTO dto) {
		return dao.admin(dto);
	}

	public int update(AdminDTO dto) {
		return dao.update(dto);
	}
	
	public int uploadFiles(TravelDTO dto) throws Exception {
		
		dto.setMainImg(uploadFile(dto.getUploadMain()));
		dto.setSubImg1(uploadFile(dto.getUploadSub1()));
		dto.setSubImg2(uploadFile(dto.getUploadSub2()));
		dto.setSubImg3(uploadFile(dto.getUploadSub3()));
		dto.setSubImg4(uploadFile(dto.getUploadSub4()));
		dto.setSubImg5(uploadFile(dto.getUploadSub5()));
		
		return dao.insert(dto);
		
	}
	
	private String uploadFile(MultipartFile file) throws Exception {
		File dest = new File(file.getOriginalFilename());
		file.transferTo(dest);
		
		Session sess = null;
		Channel channel = null;
		JSch jsch = new JSch();
	
		sess = jsch.getSession(serverUser, serverIP, serverPort);
		sess.setPassword(serverPass);
		sess.setConfig("StrictHostKeyChecking", "no");
		sess.connect();
		
		System.out.println("sftp> connected");
		
		channel = sess.openChannel("sftp");
		channel.connect();
		
		chSftp = (ChannelSftp)channel;
		
		FileInputStream fis = new FileInputStream(dest);
		chSftp.cd("/var/www/html");
		chSftp.put(fis, dest.getName());
		System.out.println("sftp> transfer complete");
		
		fis.close();
		chSftp.exit();
		
		String uploadFilePath = "";
		uploadFilePath += "http://";
		uploadFilePath += serverIP;
		uploadFilePath += ":31234";
		uploadFilePath += "/" + dest.getName();
			
		return uploadFilePath;
		
	}
	
	public int deleteTravel(String[] boardChk) {
		int row = 0;  
		for(String travelChkIdx : boardChk) {
			int idx = Integer.parseInt(travelChkIdx);
			System.out.println(idx);
	    	 row =  dao.deleteTravel(idx);
	      }
	    return row;
	}

}
