package com.korit.vocard.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.korit.vocard.common.dto.response.ResponseDto;
import com.korit.vocard.common.dto.response.voca.GetCnTermResponseDto;
import com.korit.vocard.common.dto.response.voca.GetEnTermResponseDto;
import com.korit.vocard.common.dto.response.voca.GetJpKanjiResponseDto;
import com.korit.vocard.common.dto.response.voca.GetJpVocaResponseDto;
import com.korit.vocard.common.entity.TermDetailCnEntity;
import com.korit.vocard.common.entity.TermDetailEnEntity;
import com.korit.vocard.common.entity.TermDetailJpKanjiEntity;
import com.korit.vocard.common.vo.JpVocaTermVO;
import com.korit.vocard.repository.TermCnRepository;
import com.korit.vocard.repository.TermEnRepository;
import com.korit.vocard.repository.TermJpKanjiRepository;
import com.korit.vocard.repository.TermJpVocaRepository;
import com.korit.vocard.service.TermsService;

import lombok.RequiredArgsConstructor;

/**
 * class: 일본어 단어 서비스 구현체
 * 
 * description: 일본어 단어 조회 기능을 구현합니다.
 */
@Service
@RequiredArgsConstructor
public class TermsServiceImplement implements TermsService {

    private final TermJpVocaRepository termJpVocaRepository;
    private final TermJpKanjiRepository termJpKanjiRepository;
    private final TermEnRepository termEnRepository;
    private final TermCnRepository termCnRepository;
    /**
     * description: 교재, 레벨, 일차에 해당하는 일본어 단어 목록을 조회합니다.
     * 
     * <p>
     * <ul>
     * <li>교재, 레벨, 일차로 단어 목록 조회</li>
     * <li>조회된 단어를 VO로 변환</li>
     * <li>응답 DTO 생성</li>
     * </ul>
     * </p>
     *
     * @param language 언어 코드 (예: "jp")
     * @param bookName 교재 이름
     * @param level 레벨
     * @param dayNumber 일차
     * @return 성공 시 {@link GetJpVocaResponseDto}, 실패 시 오류 응답
     */
    @Override
    public ResponseEntity<? super GetJpVocaResponseDto> getJpVoca(String language, String bookName, String level, int dayNumber) {
        List<JpVocaTermVO> terms = null;

        try {
            terms = termJpVocaRepository.findTermDetailsByBookNameAndLevelAndDayNumber(
                    language, bookName, level, dayNumber)
                    .stream()
                    .map(JpVocaTermVO::from)
                    .toList();
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return ResponseEntity.status(HttpStatus.OK).body(new GetJpVocaResponseDto(terms));
    }

    @Override
    public ResponseEntity<? super GetJpKanjiResponseDto> getJpKanji(String language, String bookName, String level, int dayNumber) {

        List<TermDetailJpKanjiEntity> termDetailJpKanjiEntities = new ArrayList<>(); 

        try {

            termDetailJpKanjiEntities = termJpKanjiRepository.findTermDetailsByBookNameAndLevelAndDayNumber(
                language, bookName, level, dayNumber
            );
                       
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetJpKanjiResponseDto.success(termDetailJpKanjiEntities);
    }

    @Override
    public ResponseEntity<? super GetEnTermResponseDto> getEnTerm(String language, String bookName, String level, int dayNumber) {

        List<TermDetailEnEntity> termDetailEnEntities = new ArrayList<>(); 

        try {

            termDetailEnEntities = termEnRepository.findTermDetailsByBookNameAndLevelAndDayNumber(
                language, bookName, level, dayNumber
            );
                       
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetEnTermResponseDto.success(termDetailEnEntities);
    }

    @Override
    public ResponseEntity<? super GetCnTermResponseDto> getCnTerm(String language, String bookName, String level, int dayNumber) {

        List<TermDetailCnEntity> termDetailCnEntities = new ArrayList<>(); 

        try {

            termDetailCnEntities = termCnRepository.findTermDetailsByBookNameAndLevelAndDayNumber(
                language, bookName, level, dayNumber
            );
                       
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return GetCnTermResponseDto.success(termDetailCnEntities);
    }
    
} 