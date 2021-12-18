-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 18, 2021 lúc 06:26 PM
-- Phiên bản máy phục vụ: 10.4.22-MariaDB
-- Phiên bản PHP: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `zingmusicplayer`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baihat`
--

CREATE TABLE `baihat` (
  `id` int(11) NOT NULL,
  `tenbaihat` varchar(100) DEFAULT NULL,
  `hinhanh` varchar(255) DEFAULT NULL,
  `tencasi` varchar(50) DEFAULT NULL,
  `url_baihat` varchar(255) DEFAULT NULL,
  `id_theloai` int(11) DEFAULT NULL,
  `loibaihat` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `baihat`
--

INSERT INTO `baihat` (`id`, `tenbaihat`, `hinhanh`, `tencasi`, `url_baihat`, `id_theloai`, `loibaihat`) VALUES
(1, 'Cưới thôi', 'https://avatar-ex-swe.nixcdn.com/song/2021/09/09/f/c/f/d/1631181753902_500.jpg', 'Masew,Đô', 'https://aredir.nixcdn.com/NhacCuaTui1021/CuoiThoi-MasewMasiuBRayTAPVietNam-7085648_hq.mp3?st=uZqwV2TwDGveaOabDz3Erw&e=1639751965&download=true', 1, 'Ma bae ma bae\r\nLàm sao cho anh đến đây và hỏi cưới em mới hay\r\nMa bae ma bae\r\nMẹ anh bảo rằng chẳng thích em nên anh cứ mãi phân vân\r\nGiống như bao cô thôi mà\r\nTìm mãi mới gặp được anh mà\r\nChúng ta *** nhau lâu rồi\r\nCũng đã ôm hôn nhau luôn rồi\r\nGiống như bao lời anh hứa\r\nGiấu mọi người làm chi nữa\r\nNgười giả vờ không *** em\r\nĐể em phải đau buồn hơn\r\nCưới em đi anh ơi\r\nGiờ em chẳng muốn lôi thôi\r\nĐợi khi 2 vạch mới cưới\r\nKhôn như anh quê em đầy\r\nCưới em đi anh ơi\r\nVề nhà rồi chúng ta chơi\r\nVì em thương nên mới thế\r\nAnh có ra sao vẫn mê\r\nCưới đi thôi anh ơi\r\nYeahhhh oh oh oh\r\nTa cưới nhau thôi anh ơi\r\nYeahhhh oh oh oh\r\n\r\n[Rap: B Ray]\r\nNgười ơi người đâu gặp gỡ làm chi\r\nKhi nào kiệu đỏ được rước nàng đi\r\nSong gia chú bác bạn dì\r\nGóp mặt chung vui vào ngày hoan hỉ\r\nCon gái là con gái rượu\r\nĐây là phi vụ cả trăm ngàn tỷ\r\nSính lễ cũng chẳng có gì\r\nMột chai rượu mật, một tấn vàng y\r\nEm ơi, em ơi mình cưới nhau đi\r\nKể từ cái ngày sét đánh không chết\r\nThì em đã kết lấy em về nhà\r\nChốt sổ vậy luôn cho bớt cồng kềnh\r\nNgày mà em va vào cuộc đời anh\r\nPhá tan cô đơn và đã không đền\r\nLà em đã nợ cả đời cả kiếp\r\nNợ thằng cu tí mình cưới nhau đi\r\n\r\n[TAP:]\r\nMa bae ma bae\r\nMẹ anh bảo rằng chẳng thích em nên anh cứ mãi phân vân\r\nYeah eh ehh\r\nMa bae ma bae\r\nKệ ai mặc ai có nói cũng chẳng quan tâm thế cho nhanh\r\nGiờ tính sao\r\nOhhhhh oh ohhhh'),
(2, 'Thất tình', 'https://avatar-ex-swe.nixcdn.com/singer/avatar/2019/06/04/b/9/b/0/1559630395269_600.jpg', 'Trịnh Đình Quang', 'https://aredir.nixcdn.com/NhacCuaTui922/ThatTinh-TrinhDinhQuang-3119900.mp3?st=s9SijEXDWQNIPLlHaHxZJg&e=1639757534&download=true', 1, 'Anh đã không giữ được nhiều hạnh phúc cho em\r\nNhiều khi giận nhau nước mắt em cứ rơi thật nhiều\r\nAnh xin lỗi em hãy tha thứ cho anh lần này\r\nĐường rời xa anh em nói đi em rất yêu anh\r\n\r\nNhưng nay cuộc sống không như anh đã ước mong\r\nCủa một tình yêu sẽ hạnh phúc giống như bao người\r\nMột người yêu em, yêu em đắm say\r\nMột người bên em bên em mỗi khi\r\nMà giờ đây nước mắt anh đã rơi rồi\r\n\r\nThật ra anh đâu, đâu có muốn chia tay như vậy\r\nNgười yêu em hơi anh lại nhớ em đang ở đâu\r\nBàn tay nhỏ bé\r\nKhuôn mặt ấy sao lại đổi thay để anh nơi này\r\nNgoài trơi mưa cứ rơi lặng thầm, chỉ còn mình anh\r\nThật sự nhiều khi muốn nhắn tin gửi cho em nhiều\r\nLại sợ người ấy đang hạnh phúc vui bên một ai\r\nTình yêu đã chết...!\r\n\r\nHai người dưng mai này chúng ta có duyên gặp lại\r\nThì anh vẫn luôn luôn yêu em như lúc mới yêu\r\nThật ra anh đâu, đâu có muốn chia tay như vậy\r\nNgười yêu em hơi anh lại nhớ em đang ở đâu\r\nBàn tay nhỏ bé\r\n\r\nKhuôn mặt ấy sao lại đổi thay để anh nơi này\r\nNgoài trơi mưa cứ rơi lặng thầm, chỉ còn riêng anh\r\nThật sự nhiều khi muốn nhắn tin gửi cho em nhiều\r\nLại sợ người ấy đang hạnh phúc vui bên một ai\r\nTình yêu đã chết...!\r\n\r\nHai người dưng mai này chúng ta có duyên gặp lại\r\nThì anh vẫn luôn luôn yêu em như lúc mới yêu'),
(3, 'Ái nộ', 'https://avatar-ex-swe.nixcdn.com/song/2021/08/30/2/1/a/e/1630316309035_500.jpg', 'Masew, Khôi Vũ', 'https://aredir.nixcdn.com/NhacCuaTui1021/AiNo1-MasewKhoiVu-7078913.mp3?st=gGyoK5DxMjAQgey_WTrK7g&e=1639833461&download=true', 1, 'Người đi xa có nhớ chăng dòng thư tay, lời hỏi thăm\r\nVài câu ca dưới ánh trăng mờ hôm đó\r\nCó ai đang trở về, lệ dần phai theo tháng năm\r\nLời biệt ly sao khó khăn, vùi đầu trong chăn gối\r\n\r\nMong được nói hết tâm tư này\r\nĐừng dối em ơi, đừng lừa em ơi\r\nĐừng vờn con tim anh như trò đùa\r\nĐừng hứa đôi ba lời cuội nhăng nha\r\n\r\nĐừng để à í a í a\r\nĐừng dối em ơi, toàn là văn thôi\r\n1 lần đau thôi anh đủ mệt rồi\r\nĐừng hứa thêm chi lệ dài trên mi\r\n\r\nĐừng để anh hóa ma lai\r\nKhói sương thật mơ màng, chết trong sự ngỡ ngàng\r\nĐôi ba lời câu hình thức ta ngân nga để lại cho nàng\r\nRồi giờ này nàng cùng với ai?\r\n\r\nChẳng còn ngày nào mặn nồng với ta\r\nĐời sang trang linh hồn lang thang\r\nPhận này ngang ngang một mình lướt trên con đò\r\nTình tang tang giai điệu ngân vang\r\nTừ biệt nhân gian à ý aa'),
(4, 'Em đã có người mới', 'https://avatar-ex-swe.nixcdn.com/song/2021/12/07/3/4/9/a/1638850193297_500.jpg', 'Tóc Tiên', 'https://aredir.nixcdn.com/NhacCuaTui1024/EmDaCoNguoiMoi-TocTienNguoicu-7122784.mp3?st=TeI-URQGLsZ5n_ZV_yajDQ&e=1639833575&download=true', 1, 'Hôm nay em mặc váy hoa như ngày đầu năm ấy\r\nĐẹp dịu dàng và thướt tha đôi môi xinh ngất ngây\r\nTa luyên thuyên đêm thứ ba anh theo hỏi đôi câu\r\nEm ở đâu? Nay sống sao?\r\nTình yêu thì anh đây vẫn chưa\r\nThế còn em thế nào?\r\n\r\nEm đã có người mới\r\nĐể cùng em đi muôn nơi\r\nNay em đã có người mới\r\nChẳng còn một mình chơi vơi\r\nSao anh chưa có người nắm lấy đôi tay\r\nHay để mong người vừa ý đến mai sau\r\nEm mong anh có người mới\r\nTrọn vẹn đến suốt đời\r\n\r\nSau chia tay hai chúng ta e ngại hơn lúc trước\r\nNhững kỉ niệm tuy đã xa đôi khi thấy vấn vương\r\nTa luyên thuyên đêm thứ ba anh theo hỏi đôi câu\r\nEm ở đâu? Nay sống sao?\r\nTình yêu thì anh nay vẫn chưa\r\nThế còn em thế nào?\r\n\r\nAnh giờ sao rồi\r\nCòn lui tới quán *** không?\r\nEm thì vẫn vậy\r\nVẫn lưu giữ kỉ niệm ngày xưa\r\nChỉ là không cô đơn nữa\r\n\r\nEm đã có người mới\r\nĐể cùng em đi muôn nơi\r\nNay em đã có người mới\r\nChẳng còn một mình chơi vơi\r\nSao anh chưa có người nắm lấy đôi tay\r\nHay để mong người vừa ý đến mai sau\r\nEm mong anh có người mới\r\nTrọn vẹn đến suốt đời'),
(5, 'Một cú lừa', 'https://avatar-ex-swe.nixcdn.com/song/2020/05/31/b/f/d/0/1590919524607_500.jpg', 'Bích Phương', 'https://aredir.nixcdn.com/NhacCuaTui999/MotCuLua-BichPhuong-6288019.mp3?st=JLKP7WepFbvALNLbqQpjIw&e=1639833743&download=true', 1, 'Vậy là tròn một năm bên nhau\r\nNgọt ngào rực rỡ như đang được sống lại tình đầu\r\nNgười ta cứ khen anh đa tình đến thế\r\nMà sao lúc yêu em si tình đến thế\r\n\r\nBọn mình thật hợp mà phải không anh ơi\r\nMột người ưa nói như em lại thích người kiệm lời\r\nNgười mà lúc bên em hay ở bên ai thì cũng tắt chuông điện thoại\r\n\r\nLúc anh chạm môi cô ta anh có ngần ngại\r\nCó ngần ngại không hay miên man nhớ mãi\r\nTrả lời đi hương nước hoa thơm mùi gì len giữa chúng ta\r\nEm trao anh con tim sao anh trao cho em một cú lừa\r\n\r\nLa la la la là lừa\r\nLa la la la là lừa\r\nLa la la la là lừa\r\n\r\nNào là mình đừng buông tay ra\r\nNào là anh ước hai ta rồi sẽ về một nhà\r\nNgười ta cứ khen anh đa tình đến thế\r\nMà sao lúc yêu em si tình...\r\n\r\nMột người phải vờ như ngây thơ\r\nMột người nói dối quá tồi\r\nTình yêu với em như ngôi đền thiêng liêng\r\nGiờ em chẳng muốn cầu nguyện\r\n\r\nBiết đâu được hai ta sớm có kết cục buồn\r\nNỗi đau này em đưa cho cơn gió cuốn\r\nĐiều gì xảy ra với em mong rằng đừng xảy ra với anh\r\nThôi ta chia tay đi nhưng riêng em sẽ không phải tiếc gì\r\n\r\nLa la la la là lừa\r\nLa la la la là lừa\r\nLa la la la là lừa\r\n\r\nLúc anh chạm môi cô ta anh có ngần ngại\r\nCó ngần ngại không hay miên man nhớ mãi\r\nĐiều gì đã quyến rũ anh, ôi điều gì đã đánh cắp anh\r\nEm trao anh con tim sao anh trao cho em...\r\n\r\nBiết đâu được hai ta sớm có kết cục buồn\r\nNỗi đau này em đưa cho cơn gió cuốn\r\nĐiều gì xảy ra với em mong rằng đừng xảy ra với anh\r\nEm trao anh con tim sao anh trao cho em một cú lừa'),
(6, 'Ngày Xưa Em Đến', 'https://zmp3-photo-fbcrawler.zadn.vn/thumb_video/1/c/1cce529f4c0abe87b3568e78e70ef179_1352559071.jpg', 'Anh Khang', 'https://aredir.nixcdn.com/NhacCuaTui793/NgayXuaEmDen-AnhKhang_4dmq4.mp3?st=Tn9q_-4hBYgTImflyWcxzw&e=1639811920&download=true', 1, 'Ngày xưa em đến như một cơn gió\r\nRồi trao tình yêu với ngàn lời hứa\r\nRằng ngày mai đôi ta gần nhau mãi sẽ không rời\r\nTrong anh giờ phút ấy in hình bóng em.\r\n\r\nRồi những năm tháng êm đềm hạnh phúc\r\nVụt qua thật nhanh không kịp tay với\r\nGiờ chỉ còn yêu thương trong những giấc mơ xa vời\r\nVà trong anh giờ đây chỉ còn nỗi nhớ.\r\n\r\n[ĐK:]\r\nKhông biết mai này đây, khi bước trên đường quen\r\nLiệu mình có gặp nhau như ngày xưa khi đông về\r\nNhẹ nhàng anh sẽ hát những bài hát để tặng riêng em\r\nAnh vẫn còn yêu em nhiều lắm người ơi !\r\n\r\nNăm tháng yêu thật lâu, hình bóng em giờ đâu ?\r\n\r\nNgọt ngào vẫn đậm sâu, mơ về em những đêm sầu\r\nDù chỉ một thoáng nhớ về anh thôi người nhé !\r\nTình này anh sẽ mãi trao về em như ngày xưa, nhé em !!!'),
(7, 'Yêu Không Cần Ép', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/cover/5/e/a/5/5ea52071348b578d0510bf9e71cf8989.jpg', 'Hứa Kim Tuyền, Trần Dũng Khánh', 'https://aredir.nixcdn.com/NhacCuaTui1024/YeuKhongCanEp-BaoAnh-7122895.mp3?st=mHVOjZ6d4itIh_ajusuQWQ&e=1639814670&download=true', 2, 'Ngày xưa em hay mộng mơ\r\nTình yêu đẹp như bài thơ\r\nLời yêu phải nói thật nhiều\r\nKèm theo là những nuông chiều\r\nNgày nay em vẫn mộng mơ\r\nTình yêu đẹp như ý thơ\r\nMà chẳng cần phải nói gì\r\nVì tình cảm đâu phải tô mỳ\r\nChàng trai của em, không ngôn tình\r\nTính hay cứ im thinh\r\nVà cũng chẳng từng nói với em\r\nNhững lời yêu đương\r\nVẫn còn tơ vương\r\n\r\nAi lại nỡ ai lại nỡ ép,\r\nÉp anh phải nói ra lời nhớ ra lời thương đau\r\nEm nào có em nào có ép\r\nÉp anh phải nói ra lời nhớ ra lời thương đau\r\nVì em cũng biết rằng lời ta khó nói\r\nLại càng thêm chất chứa bên trong thật nhiều những chân thành\r\nÉp ai lại nỡ ai lại nỡ ép\r\nÉp anh phải nói, vì lời nói chỉ nằm trên môi\r\n\r\nAnh không hôn em như người ta\r\nAnh không đưa em đi gần xa\r\nAnh không cho em những món quà mà giản đơn trong tim anh đã xem em là tất cả\r\nNhìn mắt anh là em thấy\r\nNgời sáng của mình em đấy\r\nEm đây đã sắp u30, em chỉ cần một người\r\n\r\nNgười đàn ông của em hay âm thầm\r\nĐón em lúc tan tầm\r\nBàn tay ấm dù mưa rét căm\r\nĐặt vào tay em, đặt vào tim em\r\n\r\nAi lại nỡ ai lại nỡ ép,\r\nÉp anh phải nói ra lời nhớ ra lời thương đau\r\nEm nào có em nào có ép\r\nÉp anh phải nói ra lời nhớ ra lời thương đau\r\n\r\nVì em cũng biết rằng lời ta khó nói\r\nLại càng thêm chất chứa bên trong thật nhiều những chân thành\r\nÉp ai lại nỡ ai lại nỡ ép\r\nÉp anh phải nói, vì lời nói chỉ nằm trên môi\r\n\r\nEm không sao em không sao không sao I’m okie\r\nĐôi khi em bận lòng nên em dỗi em muộn sầu\r\nEm không sao em không sao không sao I’m okie\r\nNhưng anh ơi em thật lòng mong,\r\nMong nghe được anh nói\r\nAnh yêu em, anh yêu em, anh yêu em rất nhiều\r\nDon’t you know vì chờ anh em đứng đây từ chiều.\r\n\r\nEm không sao em không sao không sao I’m okie\r\nĐôi khi em bận lòng nên em dỗi em buồn rầu\r\n\r\nVì em cũng biết rằng lời ta khó nói\r\nLại càng thêm chất chứa bên trong thật nhiều những chân thành\r\nÉp ai lại nỡ ai lại nỡ ép\r\nÉp anh phải nói, vì lời nói chỉ nằm trên môi\r\nTrên môi...'),
(8, 'Em Đã Có Người Mới', 'https://kenh14cdn.com/203336854389633024/2021/12/9/honeycam-2021-12-09-19-37-44-1639055458008754328543.gif.png', 'Tóc Tiên, Người cũ', 'https://aredir.nixcdn.com/NhacCuaTui1024/EmDaCoNguoiMoi-TocTienNguoicu-7122784.mp3?st=uDlLs55f1xI1soPjaqXKMQ&e=1639814670&download=true', 1, 'Hôm nay em mặc váy hoa như ngày đầu năm ấy\r\nĐẹp dịu dàng và thướt tha đôi môi xinh ngất ngây\r\nTa luyên thuyên đêm thứ ba anh theo hỏi đôi câu\r\nEm ở đâu? Nay sống sao?\r\nTình yêu thì anh đây vẫn chưa\r\nThế còn em thế nào?\r\n\r\nEm đã có người mới\r\nĐể cùng em đi muôn nơi\r\nNay em đã có người mới\r\nChẳng còn một mình chơi vơi\r\nSao anh chưa có người nắm lấy đôi tay\r\nHay để mong người vừa ý đến mai sau\r\nEm mong anh có người mới\r\nTrọn vẹn đến suốt đời\r\n\r\nSau chia tay hai chúng ta e ngại hơn lúc trước\r\nNhững kỉ niệm tuy đã xa đôi khi thấy vấn vương\r\nTa luyên thuyên đêm thứ ba anh theo hỏi đôi câu\r\nEm ở đâu? Nay sống sao?\r\nTình yêu thì anh nay vẫn chưa\r\nThế còn em thế nào?\r\n\r\nAnh giờ sao rồi\r\nCòn lui tới quán quen không?\r\nEm thì vẫn vậy\r\nVẫn lưu giữ kỉ niệm ngày xưa\r\nChỉ là không cô đơn nữa\r\n\r\nEm đã có người mới\r\nĐể cùng em đi muôn nơi\r\nNay em đã có người mới\r\nChẳng còn một mình chơi vơi\r\nSao anh chưa có người nắm lấy đôi tay\r\nHay để mong người vừa ý đến mai sau\r\nEm mong anh có người mới\r\nTrọn vẹn đến suốt đời'),
(9, 'Đế Vương', 'https://avatar-ex-swe.nixcdn.com/song/share/2021/11/29/e/8/1/a/1638180198254.jpg', 'Đình Dũng, ACV', 'https://aredir.nixcdn.com/NhacCuaTui1024/DeVuong-DinhDungACV-7121634.mp3?st=CwuNFlZgSYKaL_t-MRxd8g&e=1639814670&download=true', 1, 'Một bậc quân vương mang trong con tim hình hài đất nước\r\nNgỡ như dân an ta sẽ chẳng bao giờ buồn\r\nNào ngờ một hôm ngao du nhân gian chạm một ánh mắt\r\nKhiến cho ta say ta mê như chốn thiên đường\r\nTrời cao như đang trêu ngươi thân ta khi bông hoa ấy\r\nTrót mang con tim trao cho một nam nhân thường\r\nGiận lòng ta ban cho bông hoa thơm hồi về cung cấm\r\nKhiến em luôn luôn bên ta mãi mãi không buông\r\n\r\nMà nào ngờ đâu thân em nơi đây tâm trí nơi nào ?\r\nNhìn về quê hương em ôm tương tư nặng lòng biết bao\r\nMột người nam nhân không vinh không hoa mà có lẽ nào ?\r\nNgười lại yêu thương quan tâm hơn ta một Đế Vương sao ?\r\nGiọt lên Quân Vương không khi nao rơi khi nước chưa tàn\r\nMà tình chưa yên nên vương trên mi giọt buồn chứa chan\r\nĐành lòng buông tay cho em ra đi với mối tình vàng\r\nMột bậc quân vương uy nghiêm oai phong nhưng tim nát tan'),
(10, 'Người Yêu Mới Em Tên Gì', 'https://i.ytimg.com/vi/h9Mieiulpts/mqdefault.jpg', 'Cao Nam Thành', 'https://aredir.nixcdn.com/NhacCuaTui1024/NguoiYeuMoiEmTenGi-CaoNamThanh-7123082.mp3?st=Rl2rI1-P1Su666vxlGsCkA&e=1639814670&download=true', 1, 'Cuộc đời sao trớ trêu\r\nChẳng yên thân một hướng\r\nCứ bôn ba muôn phương tìm quá khứ\r\nVà ngày hôm nay đây, anh không nói thành lời\r\nVì em xa trái tim này nặng trĩu\r\n\r\nMình đã hoá yêu thương này thành tổn thương\r\nNhịp tim anh lúc này sao quá thất thường\r\nHạnh phúc đâu ai lựa chọn hay mua\r\nTìm được nhau khó như thế nào\r\nNhưng ta lạc mất đi tại sao\r\n\r\nNgười yêu mới em tên là gì có cùng suy nghĩ anh không\r\nNgười yêu mới em chắc chưa được nhận điều cay đắng\r\nVì hạnh phúc ai lúc bắt đầu cũng ngọt ngào nhiều khắc sâu\r\nĐể rồi đến khi bên nhau lâu dài thành thương đau\r\n\r\nChọn lựa cách yêu thêm 1 người sẽ làm em cười vui sao\r\nChẳng lẽ tháng năm anh cận kề đều là giông bão\r\nChọn lựa cách quên đi tên anh đó là bên người tiếp theo\r\nDù sao cũng cảm ơn yêu thương này thật không may'),
(11, 'Về Nhà (25 Mét Vuông)', 'https://data.chiasenhac.com/data/cover/152/151276.jpg', 'Hoàng Dũng', 'https://aredir.nixcdn.com/NhacCuaTui1024/VeNha25MetVuong-HoangDungTheVoice-7123127.mp3?st=EsBBkXCedqVG1W63aizQaQ&e=1639814670&download=true', 2, 'Lúc em nhìn anh từ phía xa\r\nEm có thấy anh cười hạnh phúc như muốn nói “có anh ở đây”?\r\nLúc anh kể nghe những giấc mơ\r\nEm có thấy dáng hình của em như vốn dĩ vẫn luôn ở đấy?\r\nAnh mong anh cùng em đi trọn trời đất rộng dài bằng điệu nhạc tiếng ca\r\nNhững ánh mắt dù quen hay lạ cũng sẽ mỉm cười dù rằng không nói ra\r\nTa đem gieo thật tâm, một ngày sẽ hái ngọt ngào\r\nAnh tin em biết mà\r\n\r\nNhưng nếu hôm nay không thể vững bước\r\nAnh chỉ muốn ôm em ngủ say\r\nNếu hôm nay mệt nhoài biết mấy\r\nAnh chỉ muốn được về nhà\r\n\r\nLúc anh lặng im ôm lấy em\r\nEm có nghĩ em là bình yên giữa những bão giông bủa vây?\r\n\r\nEm ơi, có kẻ phiêu lưu nào đi suốt cuộc đời mà chẳng cần một mái nhà?\r\nBao nhiêu cơn giông bão thét gào hay hát thì thầm một ngày rồi cũng sẽ qua\r\nAnh luôn tin rằng thứ sau cùng vẫn sẽ ở lại là tình yêu chúng ta\r\n\r\nNên nếu hôm nay chẳng thể vững bước\r\nAnh chỉ muốn ôm em ngủ say\r\nNếu hôm nay mệt nhoài biết mấy\r\nAnh chỉ muốn được về nhà\r\nNếu hôm nay chẳng thể vững bước\r\nAnh chỉ muốn ôm em ngủ say\r\nNếu hôm nay mệt nhoài biết mấy\r\nAnh chỉ muốn được về nhà\r\n\r\nAnh đang trên đường về với em\r\nAnh đang trên đường về nhà\r\nAnh đang trên đường về với em\r\nAnh đang trên đường về nhà'),
(12, 'Lời Yêu Cũ Anh Chốt Từ', 'https://avatar-ex-swe.nixcdn.com/song/2021/12/09/4/2/0/1/1639040297193.jpg', 'Hương Ly', 'https://aredir.nixcdn.com/NhacCuaTui1024/LoiYeuCuAnhChotTu-HuongLy-7123076.mp3?st=sPX4_VnqiyM_v27UfIe-RA&e=1639814670&download=true', 2, 'Giờ anh tự quyết buông tay em phải không\r\nChờ mong chi nữa lời hứa anh đâu thật lòng\r\nEm chẳng cần nghe những lời giải thích\r\nTừ một phía chỉ thêm vô ích\r\nCứ thế cho qua cãi vã càng thêm xót xa\r\nVậy thì anh cứ bước cùng cô ta\r\nEm không trách anh đâu mà\r\nChỉ là em tiếc thời gian qua\r\nĐã từng yêu anh thiết tha\r\n\r\nNgày anh đi bỏ rơi em lại\r\nLà ngày em như kẻ điên dại\r\nĐoạn đường ta chung bước thật dài\r\nSao anh nỡ chia làm hai\r\nLời yêu cũ anh đã chối từ\r\nThì dễ chi làm anh khó xử\r\nNgười khác lối thế vai em rồi\r\nHạnh phúc anh giữ ngoại trừ em thôi'),
(13, 'Bởi Vì Yêu', 'https://avatar-ex-swe.nixcdn.com/song/share/2021/11/25/c/0/d/d/1637810847725.jpg', 'Juky San', 'https://aredir.nixcdn.com/NhacCuaTui1024/BoiViYeu-JukySan-7120987.mp3?st=uIOS-bJLaB0zeivnUkF6Ig&e=1639814670&download=true', 1, 'Intro:...\r\n\r\nChorus:\r\nBởi vì em thấy nhớ anh nhớ anh nhớ anh\r\nBởi vì em mong có anh có anh có anh\r\nNgười làm em cứ ngóng trông hoài\r\nNgười làm em thao thức đêm ngày\r\n\r\nLiệu rằng anh có nhớ em giống em nhớ anh\r\nLiệu rằng anh có muốn ta có nhau đến sau này\r\nSợ mình em sẽ mãi yêu thầm\r\nSợ mình anh cứ mãi lặng thầm\r\nTa cứ thế thôi\r\n\r\nVer:\r\nBao nhiêu lâu rồi em cứ ôm suy tư mà thôi\r\nLàm sao để anh biết em nhớ người\r\nPhải làm sao để trái tim thốt ra câu tình yêu\r\n\r\nQua bao nhiêu thời gian quá lâu em cứ mãi mong\r\nGần bên, em và anh chẳng xa rời\r\nTa cùng nhau đi đến chân trời\r\n\r\nPre:\r\nCó bao nhiêu chông gai vào ngày mai\r\nNhiều lắm chênh vênh lênh đênh đời đổi thay\r\nChẳng sao đâu khi em được gần anh\r\nCó anh\r\n\r\nVì em biết bên anh em luôn là em nhất\r\nĐừng để cho em cô đơn ngày ngày cứ mong chờ\r\nChờ anh đến bên em\r\n\r\nChorus:\r\nBởi vì em thấy nhớ anh nhớ anh nhớ anh\r\nBởi vì em mong có anh có anh có anh\r\nNgười làm em cứ ngóng trông hoài\r\nNgười làm em thao thức đêm ngày\r\n\r\nLiệu rằng anh có nhớ em giống em nhớ anh\r\nLiệu rằng anh có muốn ta có nhau đến sau này\r\nSợ mình em sẽ mãi yêu thầm\r\nSợ mình anh cứ mãi lặng thầm\r\nTa cứ thế thôi\r\n\r\nRap:\r\nPhải buông lời xin lỗi nếu anh làm em ngả nghiêng, lòng này chả yên nhưng xa nhau là tốt hơn\r\nEm chỉ là vô tình lạc vào lòng của gã điên\r\nTa chỉ là hai người đến từ hai ngã riêng\r\n\r\nNhư là thần cupid với cung trên tay mình\r\nVô tình bắn lạc mũi tên để ta thấy tim nhau\r\nNhư là mơ, tay ta nắm phải một sợi dây tình\r\nLeo lên trên cao, ta tìm nhau trong chiêm bao\r\n\r\nPre:\r\nCó bao nhiêu chông gai vào ngày mai\r\nNhiều lắm chênh vênh lênh đênh đời đổi thay\r\nChẳng sao đâu khi em được gần anh\r\nCó anhhhhh\r\n\r\nVì em biết bên anh em luôn là em nhất\r\nĐừng để cho em cô đơn ngày ngày cứ mong chờ\r\nChờ anh đến bên em\r\n\r\nChorus:\r\n(Bởi vì em thấy nhớ anh nhớ anh nhớ anh\r\nBởi vì em mong có anh có anh có anh\r\nNgười làm em cứ ngóng trông hoài\r\nNgười làm em thao thức đêm ngày\r\n\r\nLiệu rằng anh có nhớ em giống em nhớ anh\r\nLiệu rằng anh có muốn ta có nhau đến sau này\r\nSợ mình em sẽ mãi yêu thầm\r\nSợ mình anh cứ mãi lặng thầm\r\nTa cứ thế thôi) x3'),
(14, 'Chống Lại Thế Giới', 'https://photo-resize-zmp3.zadn.vn/w240_r1x1_jpeg/cover/c/3/e/6/c3e664e559e08f505fa20993fd8bd5ee.jpg', 'Ngô Kiến Huy', 'https://aredir.nixcdn.com/NhacCuaTui1024/ChongLaiTheGioi-NgoKienHuy-7120548.mp3?st=r7huCuVp8AfoGlMaxFZ8bA&e=1639814670&download=true', 1, 'Nói anh nghe đi em những tổn thương trong em hôm qua\r\nAnh sẽ lấy yêu thương trong anh xoa dịu lòng em\r\nKể anh nghe đi em những ước mơ trong em mai sau\r\nAnh với em sẽ thực hiện cùng nhau, nắm tay anh đi em\r\n\r\nMai bão giông hay mưa trong đêm, em hãy hứa bên anh\r\nBên anh không bao giờ lìa xa dẫu trong quá khứ đó\r\nAnh có mang cho em âu lo thì đừng vì thế mà giận hờn anh nha\r\nNếu như mai này ai làm em khóc thì hãy đến cạnh bên\r\n\r\nThì thầm cùng anh, lau nước mắt xong ta sẽ đứng lên đi tìm niềm vui\r\nNếu như mai này cuộc đời buồn chán thì hãy cầm tay chạy khắp thế gian\r\nChỉ có nhau thôi, chỉ có nhau thôi suốt đời\r\nNếu như mai này đường đời sóng gió\r\n\r\nThì mình hãy cùng nhau bình tâm bước qua\r\nTa vẫn bước bên nhau, bên nhau bên nhau như ngày đầu tiên\r\nNếu như mai này ngoài kia thế giới ai có cản ngăn tình yêu chúng ta\r\nAnh sẽ chống lại cả thế giới để yêu em đến già'),
(15, 'Bước Qua Nhau', 'https://vcdn-ngoisao.vnecdn.net/2011/07/21/buocqua3-123646-1368181952_1200x0.jpg', 'Vũ', 'https://aredir.nixcdn.com/NhacCuaTui1024/BuocQuaNhau-Vu-7120388.mp3?st=FV1ftyzhNJ8pzuowy7eXbA&e=1639814670&download=true', 2, 'Cuộc đời cứ trôi, ta nhìn lại ngày tháng còn bên nhau cùng những thăng trầm.\r\nTại sao không vẫy tay chào nơi ta đứng bây giờ hai nơi hai người dưng.\r\nĐợi em bước qua để khiến anh nhận ra là đôi mắt em còn đang buồn.\r\nMàu hoa cài áo vẫn còn như lời hứa đã từng giờ đây còn như xưa.\r\nDòng người vội vàng bước qua, chợt như chiếc hôn thế thôi.\r\n\r\nĐôi môi chia làm đôi như ta đang mong vậy thôi\r\nNgười nghẹn ngào bước đi, chợt như chúng ta quay về\r\nGiấu trái tim mình và đừng thổn thức khi thấy nhau\r\nĐoàn tàu kia dừng lại, còn hai ta bước qua nhau\r\n\r\n[BRIDGE:]\r\nTrôi đi theo mây trời\r\nTừng cảm xúc trong tim anh đang cô đơn cùng với ngàn lời\r\nViết riêng cho bài ca tình đầu\r\nChỉ còn lại một thói *** từ lâu'),
(16, 'chiếc hộp', 'https://avatar-ex-swe.nixcdn.com/song/share/2021/11/19/b/e/5/0/1637317223508.jpg', 'Bích Phương', 'https://aredir.nixcdn.com/NhacCuaTui1024/ChiecHop-BichPhuong-7120378.mp3?st=d8v1ys11GPWSabTJM_swfA&e=1639814670&download=true', 1, 'Ta đi ngang bao phút vui buồn cùng nhau.\r\nSau chia tay có lẽ em không còn giận.\r\nĐột nhiên em nghĩ mình làm gì\r\nKhi ở trong tim ai cũng có một chiếc hộp\r\n\r\nLưu bao nhiêu kí ức về nhau khi yêu.\r\nNếu như cho anh chọn thì anh có cất chiếc hôn đầu tiên?\r\nNếu như cho anh chọn thì anh có cất chiếc ôm mùa đông?\r\nChờ anh qua những tối đường rất xa chỉ để mong có mỗi mấy phút ôm.\r\n\r\nNếu như cho em chọn thì em xin cất những điều đẹp nhất.\r\nTa yêu nhau rồi cứ thế xa rời nhau.\r\nHôm chia tay anh tiễn em về một đoạn.\r\nGiờ đây em nghĩ rằng ta đã đúng dù cho khi đó thấy xót xa vô cùng.\r\n\r\nEm luôn mong anh cũng cảm nhận như em.\r\nNếu như cho anh chọn thì anh có cất ánh chiều hoàng hôn.\r\nDát lên nơi ta thường ngồi lâu tay nắm khó mà chặt hơn.\r\n\r\nNgồi bên nhau yên ắng chỉ chúng ta vì ta đâu *** hứa thứ quá xa.\r\nNếu như cho em chọn thì em xin cất những điều đẹp nhất.\r\nNếu như cho anh chọn liệu anh có cất những điều đẹp nhất?');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `baihatyeuthich`
--

CREATE TABLE `baihatyeuthich` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `id_baihat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `baihatyeuthich`
--

INSERT INTO `baihatyeuthich` (`id`, `id_user`, `id_baihat`) VALUES
(3, 1, 1),
(4, 3, 3),
(5, 3, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `banner`
--

CREATE TABLE `banner` (
  `id` int(11) NOT NULL,
  `hinhanh` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `banner`
--

INSERT INTO `banner` (`id`, `hinhanh`) VALUES
(1, 'https://chiasetainguyen.com/upload-file/cochacyeuladay-sontung-mtp5f05944edc40f.jpg'),
(2, 'https://nhacxua.vn/wp-content/uploads/2019/11/saigon.jpg'),
(3, 'https://i.ytimg.com/vi/CIkbiAs-HKM/maxresdefault.jpg');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `playlist`
--

CREATE TABLE `playlist` (
  `id` int(11) NOT NULL,
  `id_user` int(11) DEFAULT NULL,
  `tenplaylist` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `playlist`
--

INSERT INTO `playlist` (`id`, `id_user`, `tenplaylist`) VALUES
(1, 1, 'Kinh di'),
(3, 3, 'Hay nghe');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `playlist_chitiet`
--

CREATE TABLE `playlist_chitiet` (
  `id` int(11) NOT NULL,
  `id_playlist` int(11) DEFAULT NULL,
  `id_baihat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `playlist_chitiet`
--

INSERT INTO `playlist_chitiet` (`id`, `id_playlist`, `id_baihat`) VALUES
(5, 1, 2),
(8, 3, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `taikhoan`
--

CREATE TABLE `taikhoan` (
  `id` int(11) NOT NULL,
  `tentaikhoan` varchar(30) DEFAULT NULL,
  `matkhau` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `taikhoan`
--

INSERT INTO `taikhoan` (`id`, `tentaikhoan`, `matkhau`) VALUES
(1, 'vinadeka', '1234567'),
(2, 'vinadeka1', '123456'),
(3, 'tai', '123');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `theloai`
--

CREATE TABLE `theloai` (
  `id` int(11) NOT NULL,
  `tentheloai` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `theloai`
--

INSERT INTO `theloai` (`id`, `tentheloai`) VALUES
(1, 'Nhạc Trẻ'),
(2, 'Trữ Tình'),
(3, 'Kinh Dị'),
(4, 'Thiếu nhi');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `baihat`
--
ALTER TABLE `baihat`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fr_baihat_theloai` (`id_theloai`);

--
-- Chỉ mục cho bảng `baihatyeuthich`
--
ALTER TABLE `baihatyeuthich`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fr_baihatyeuthich_user` (`id_user`),
  ADD KEY `fr_baihatyeuthich_baihat` (`id_baihat`);

--
-- Chỉ mục cho bảng `banner`
--
ALTER TABLE `banner`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `playlist`
--
ALTER TABLE `playlist`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fr_playlist_taikhoan` (`id_user`);

--
-- Chỉ mục cho bảng `playlist_chitiet`
--
ALTER TABLE `playlist_chitiet`
  ADD PRIMARY KEY (`id`),
  ADD KEY `playlist_chitiet_playlist` (`id_playlist`);

--
-- Chỉ mục cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `theloai`
--
ALTER TABLE `theloai`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `baihat`
--
ALTER TABLE `baihat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT cho bảng `baihatyeuthich`
--
ALTER TABLE `baihatyeuthich`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT cho bảng `playlist`
--
ALTER TABLE `playlist`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `playlist_chitiet`
--
ALTER TABLE `playlist_chitiet`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `taikhoan`
--
ALTER TABLE `taikhoan`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `theloai`
--
ALTER TABLE `theloai`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `baihat`
--
ALTER TABLE `baihat`
  ADD CONSTRAINT `fr_baihat_theloai` FOREIGN KEY (`id_theloai`) REFERENCES `theloai` (`id`);

--
-- Các ràng buộc cho bảng `baihatyeuthich`
--
ALTER TABLE `baihatyeuthich`
  ADD CONSTRAINT `fr_baihatyeuthich_baihat` FOREIGN KEY (`id_baihat`) REFERENCES `baihat` (`id`),
  ADD CONSTRAINT `fr_baihatyeuthich_user` FOREIGN KEY (`id_user`) REFERENCES `taikhoan` (`id`),
  ADD CONSTRAINT `fr_playchitiet_baihat` FOREIGN KEY (`id_baihat`) REFERENCES `baihat` (`id`);

--
-- Các ràng buộc cho bảng `playlist`
--
ALTER TABLE `playlist`
  ADD CONSTRAINT `fr_playlist_taikhoan` FOREIGN KEY (`id_user`) REFERENCES `taikhoan` (`id`);

--
-- Các ràng buộc cho bảng `playlist_chitiet`
--
ALTER TABLE `playlist_chitiet`
  ADD CONSTRAINT `playlist_chitiet_playlist` FOREIGN KEY (`id_playlist`) REFERENCES `playlist` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
