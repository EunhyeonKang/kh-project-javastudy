package kr.or.board.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.or.board.model.service.BoardService;
import kr.or.board.model.vo.Board;

@Controller
public class BoardController {
	@Autowired
	private BoardService service;

	@RequestMapping(value = "/boardWriteFrm.do")
	public String boardWriteFrm() {
		return "board/boardWriteFrm";
	}

	@RequestMapping(value = "boardWrite.do")
	public String boardWrite(Board b, MultipartFile files[], HttpServletRequest request,Model model) {
		// 파일 목록을 저장할 리스트 생성
		ArrayList<kr.or.board.model.vo.File> fileList = new ArrayList<kr.or.board.model.vo.File>();
		// 파일이 존재하지 않더라도 배열은 무조건 길이 1을 가짐
		if (files[0].isEmpty()) {
			// 첨부파일이 없는경우
		} else {
			// 첨부파일이 있는경우
			// 파일처리
			// getRealPath() -> webapp 폴더
			String savePath = request.getSession().getServletContext().getRealPath("/resources/upload/board/");
			for (MultipartFile file : files) {
				// 실제 유저가 올린 파일명(filename)
				String filename = file.getOriginalFilename();
				// 유저가 올린 파일명을 마지막 . 기준으로 분리 test.txt ->test_1.txt img01.jpg -> img01_1.jpg
				String onlyFilename = filename.substring(0, filename.indexOf("."));
				String extention = filename.substring(filename.indexOf("."));
				String filepath = null;
				int count = 0;
				while (true) {
					if (count == 0) {
						filepath = onlyFilename + extention; // test.txt1
					} else {
						filepath = onlyFilename + "_" + count + extention; // test_1.txt
					}
					File checkFile = new File(savePath + filepath);
					if (!checkFile.exists()) {
						break;
					}
					count++;
				}
				kr.or.board.model.vo.File f = new kr.or.board.model.vo.File();
				f.setFilename(filename);
				f.setFilepath(filepath);
				fileList.add(f);
				System.out.println("filename : " + filename);
				System.out.println("filepath : " + filepath);
				try {
					FileOutputStream fos = new FileOutputStream(new File(savePath + filepath));
					BufferedOutputStream bos = new BufferedOutputStream(fos);
					byte[] bytes = file.getBytes();
					bos.write(bytes);
					bos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		int result = service.insertBoard(b,fileList);
		if(result != -1 && result == fileList.size()) {
			model.addAttribute("msg","등록성공");
		}else {
			model.addAttribute("msg","등록실패");
		}
		model.addAttribute("loc","/");
		return "common/msg";
	}
	@RequestMapping(value="/boardList.do")
	public String boardList(Model model) {
		ArrayList<Board> list = service.boardList();
		model.addAttribute("list",list);
		return "board/boardList";
	}
	@RequestMapping(value="/boardView.do")
	public String boardView(int boardNo, Model model) {
		Board board = service.boardView(boardNo);
		model.addAttribute("board",board);
		return "board/boardView";
	}

}
