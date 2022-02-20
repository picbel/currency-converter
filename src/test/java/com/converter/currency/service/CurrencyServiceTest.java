package com.converter.currency.service;

import com.converter.currency.model.dto.CurrencyResponseDTO;
import com.converter.currency.model.dto.ExchangeRateDTO;
import com.converter.currency.util.Constants;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTest {

    @Mock
    RestTemplate restTemplate;

    @InjectMocks
    CurrencyService currencyService;

    ObjectMapper objectMapper;

    @BeforeEach
    void setting(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        objectMapper = mapper;
    }

    @DisplayName("필요한 환율리스트 테스트 USDJPY, USDKRW, USDPHP")
    @Test
    void getUsedExchangeRateList() throws Exception {
        //given
        List<ExchangeRateDTO> result = new ArrayList<>();

        result.add(ExchangeRateDTO.builder()
                .code("USDJPY")
                .name("일본(JPY)")
                .exchangeRate(115.0)
                .build());

        result.add(ExchangeRateDTO.builder()
                .code("USDKRW")
                .name("한국(KRW)")
                .exchangeRate(1195.73)
                .build());

        result.add(ExchangeRateDTO.builder()
                .code("USDPHP")
                .name("필리핀(PHP)")
                .exchangeRate(51.44)
                .build());

        String url = Constants.CURRENCYLAYER_API_URL + "live?access_key="+Constants.API_ACCESS_KEY;
        String body = "{\"terms\":\"https://currencylayer.com/terms\",\"privacy\":\"https://currencylayer.com/privacy\",\"timestamp\":\"1645344662\",\"source\":\"USD\",\"quotes\":{\"USDAED\":3.673042,\"USDAFN\":91.903991,\"USDALL\":107.350403,\"USDAMD\":478.024952,\"USDANG\":1.802387,\"USDAOA\":507.551041,\"USDARS\":106.793999,\"USDAUD\":1.393923,\"USDAWG\":1.80025,\"USDAZN\":1.70397,\"USDBAM\":1.721416,\"USDBBD\":2.019258,\"USDBDT\":86.099175,\"USDBGN\":1.725052,\"USDBHD\":0.377052,\"USDBIF\":2017.0,\"USDBMD\":1.0,\"USDBND\":1.343707,\"USDBOB\":6.885386,\"USDBRL\":5.139041,\"USDBSD\":1.000035,\"USDBTC\":2.5783542E-5,\"USDBTN\":74.67984,\"USDBWP\":11.481746,\"USDBYN\":2.567826,\"USDBYR\":19600.0,\"USDBZD\":2.015825,\"USDCAD\":1.27565,\"USDCDF\":2015.000362,\"USDCHF\":0.921513,\"USDCLF\":0.029038,\"USDCLP\":801.250396,\"USDCNY\":6.325304,\"USDCOP\":3931.17,\"USDCRC\":639.821856,\"USDCUC\":1.0,\"USDCUP\":26.5,\"USDCVE\":97.703897,\"USDCZK\":21.43495,\"USDDJF\":177.720394,\"USDDKK\":6.57057,\"USDDOP\":56.390393,\"USDDZD\":140.58104,\"USDEGP\":15.736549,\"USDERN\":15.000019,\"USDETB\":50.650392,\"USDEUR\":0.883204,\"USDFJD\":2.13504,\"USDFKP\":0.72792,\"USDGBP\":0.735608,\"USDGEL\":2.980391,\"USDGGP\":0.72792,\"USDGHS\":6.603858,\"USDGIP\":0.72792,\"USDGMD\":53.25039,\"USDGNF\":8985.000355,\"USDGTQ\":7.694955,\"USDGYD\":209.231094,\"USDHKD\":7.80051,\"USDHNL\":24.55504,\"USDHRK\":6.655404,\"USDHTG\":102.807703,\"USDHUF\":315.240388,\"USDIDR\":14366.9,\"USDILS\":3.20199,\"USDIMP\":0.72792,\"USDINR\":74.684404,\"USDIQD\":1459.5,\"USDIRR\":42250.000352,\"USDISK\":124.503816,\"USDJEP\":0.72792,\"USDJMD\":156.213914,\"USDJOD\":0.709304,\"USDJPY\":114.998504,\"USDKES\":113.703804,\"USDKGS\":84.803801,\"USDKHR\":4065.503799,\"USDKMF\":434.875039,\"USDKPW\":900.000157,\"USDKRW\":1195.730384,\"USDKWD\":0.30235,\"USDKYD\":0.833421,\"USDKZT\":428.478383,\"USDLAK\":11377.000349,\"USDLBP\":1512.000349,\"USDLKR\":202.509836,\"USDLRD\":154.000348,\"USDLSL\":15.130382,\"USDLTL\":2.95274,\"USDLVL\":0.60489,\"USDLYD\":4.590381,\"USDMAD\":9.449504,\"USDMDL\":17.990802,\"USDMGA\":3975.000347,\"USDMKD\":54.324209,\"USDMMK\":1778.170624,\"USDMNT\":2858.831164,\"USDMOP\":8.034695,\"USDMRO\":356.999828,\"USDMUR\":43.852483,\"USDMVR\":15.450378,\"USDMWK\":803.503739,\"USDMXN\":20.291104,\"USDMYR\":4.186039,\"USDMZN\":63.830377,\"USDNAD\":15.130377,\"USDNGN\":415.870377,\"USDNIO\":35.460377,\"USDNOK\":8.981104,\"USDNPR\":119.484589,\"USDNZD\":1.492249,\"USDOMR\":0.384983,\"USDPAB\":1.000123,\"USDPEN\":3.750375,\"USDPGK\":3.515039,\"USDPHP\":51.440375,\"USDPKR\":175.350375,\"USDPLN\":4.000578,\"USDPYG\":6936.787072,\"USDQAR\":3.641038,\"USDRON\":4.366404,\"USDRSD\":103.845038,\"USDRUB\":77.435038,\"USDRWF\":1019.0,\"USDSAR\":3.752366,\"USDSBD\":8.080873,\"USDSCR\":14.497375,\"USDSDG\":444.503678,\"USDSEK\":9.39498,\"USDSGD\":1.345865,\"USDSHP\":1.377404,\"USDSLL\":11557.503669,\"USDSOS\":584.000338,\"USDSRD\":20.606038,\"USDSTD\":20697.981008,\"USDSVC\":8.751408,\"USDSYP\":2511.999776,\"USDSZL\":15.12037,\"USDTHB\":32.154038,\"USDTJS\":11.290663,\"USDTMT\":3.51,\"USDTND\":2.887038,\"USDTOP\":2.26795,\"USDTRY\":13.650368,\"USDTTD\":6.753186,\"USDTWD\":27.875038,\"USDTZS\":2315.000336,\"USDUAH\":28.337272,\"USDUGX\":3510.15702,\"USDUSD\":1.0,\"USDUYU\":43.037072,\"USDUZS\":10845.000335,\"USDVEF\":2.1383022233807285E11,\"USDVND\":22830.0,\"USDVUV\":113.671414,\"USDWST\":2.612343,\"USDXAF\":577.332917,\"USDXAG\":0.044408,\"USDXAU\":5.53E-4,\"USDXCD\":2.70255,\"USDXDR\":0.712736,\"USDXOF\":576.000332,\"USDXPF\":105.750364,\"USDYER\":250.250364,\"USDZAR\":15.116504,\"USDZMK\":9001.203593,\"USDZMW\":17.425979,\"USDZWL\":321.999592}}\n";
        CurrencyResponseDTO currencyResponseDTO = objectMapper.readValue(body, CurrencyResponseDTO.class);

        ResponseEntity<CurrencyResponseDTO> exchange = new ResponseEntity<>(currencyResponseDTO, HttpStatus.OK);

        given(restTemplate.exchange(eq(url), eq(HttpMethod.GET), any(HttpEntity.class), eq(CurrencyResponseDTO.class)))
                .willReturn(exchange);

        //when
        List<ExchangeRateDTO> usedExchangeRateList = currencyService.getUsedExchangeRateList();

        //then
        assertThat(usedExchangeRateList.containsAll(result)).isTrue();
    }

}