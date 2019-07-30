#Danh sách API

###1. Danh sách phim nổi bật (trang chủ)
- Phim đề cử (PDC)
- Phim chiếu rạp (PCR)
- Phim xem nhiều nhất trong ngày (PXNN)
- Phim lẻ mới (PLM)
- Phim bộ mới (PBM)
- Phim hoạt hình mới (PHHM)

```
{
	"timestamp": "2019-07-30T02:13:59.799+0000",
    "status": 1,
    "error": "",
    "data": [
    	{
			"id": "PDC",
			"title": "Phim đề cử",
			"movies": [
				{
					"id": "1",
					"title": "Avenger: End game",
					"desc": "Một bộ phim của vũ trụ điện anh Marvel...",
					"thumbnail": "http://image...",
					"viewNumbers": "96",
					"imdb": "9.5"
				},
				{
					"id": "2",
					"title": "Ironman 3: War",
					"desc": "Quay trở lại với Tony Stark, siêu anh hùng được yêu mến nhất...",
					"thumbnail": "http://image...",
					"viewNumbers": "69",
					"imdb": "8.5"
				},
				...
				(mỗi mục gồm 20 phim)
			]
		},
    	{
			"id": "PCR",
			"title": "Phim chiếu rạp",
			"movies": [
				{
					"id": "21",
					"title": "Trùm, cớm và ác quỷ",
					"desc": "Phim trinh thám Hàn Quốc đang làm sóng gió tại các rạp thế giới...",
					"thumbnail": "http://image...",
					"viewNumbers": "15450",
					"imdb": "8.5"
				},
				{
					"id": "22",
					"title": "Avatar",
					"desc": "Bộ phim 3D đầu tiên dòng phim phiêu lưu, viễn tưởng...",
					"thumbnail": "http://image...",
					"viewNumbers": "72213",
					"imdb": "8"
				},
				...
				(mỗi mục gồm 20 phim)
			]
		}
		...
	]
}

```

###2. Danh sách thể loại (categories) 
- Phim chiếu rạp (PCR)
- Phim lẻ mới (PLM)
- Phim bộ mới (PBM)
- Phim hành động (PHD)
- Phim kiếm hiệp (PKH)
- Phim kinh dị (PKD)
- Phim phiêu lưu, viễn tưởng (PLVT)
- Phim hài (PH)
- Phim tình cảm (TC)
- TV Show, gameshow (TVG)
- Phim hoạt hình (PHH)
- Phim Mỹ (PM)
- Phim Trung Quốc (PTQ)
- Phim Hàn Quốc (PHQ)
- Phim Hồng Kông TVB (TVB)

```
{
	"timestamp": "2019-07-30T02:13:59.799+0000",
    "status": 1,
    "error": "",
    "data": [
    	{
        	"id": "PCR",
        	"title": "Phim chiếu rạp"
	    },
   		{
        	"id": "PLM",
        	"title": "Phim lẻ mới"
    	},
    	{
        	"id": "PBM",
        	"title": "Phim bộ mới"
    	},
    	...
    ]
]
```

###3. Danh sách phim theo từng thể loại (tương ứng mục 1 + 2 ở trên)

`Request params: id category, pageIndex`

```
{
	"timestamp": "2019-07-30T02:13:59.799+0000",
    "status": 1,
    "error": "",
    "data": [
		{
			"id": "1",
			"title": "Avenger: End game",
			"desc": "Một bộ phim của vũ trụ điện anh Marvel...",
			"thumbnail": "http://image...",
			"viewNumbers": 96,
			"imdb": 8.5
		},
		{
			"id": "2",
			"title": "Ironman 3: War",
			"desc": "Quay trở lại với Tony Stark, siêu anh hùng được yêu mến nhất...",
			"thumbnail": "http://image...",
			"viewNumbers": 69,
			"imdb": 8
		},
		...
	]
]
```

###4. Danh sách phim có IMDB giảm dần
`Request params: pageIndex`

```
{
	"timestamp": "2019-07-30T02:13:59.799+0000",
    "status": 1,
    "error": "",
    "data": [
		{
			"id": "89",
			"title": "Vượt ngục",
			"desc": "Một bộ phim vang danh trong lịch sử điện ảnh...",
			"thumbnail": "http://image...",
			"viewNumbers": 2787124,
			"imdb": "9.5"
		},
		{
			"id": "66",
			"title": "Bad Genius",
			"desc": "Thiên tài luôn có cuộc sống rất khác biệt...",
			"thumbnail": "http://image...",
			"viewNumbers": 698397,
			"imdb": "9"
		},
		{
			"id": "145",
			"title": "Avenger 1",
			"desc": "Phim đầu tiên của biệt đội siêu anh hùng...",
			"thumbnail": "http://image...",
			"viewNumbers": 7428402,
			"imdb": 9
		},
		...
	]
]
```

###5. Tìm kiếm phim theo nhiều điều kiện kết hợp

`Request params: queryText, pageIndex`

```
{
	"timestamp": "2019-07-30T02:13:59.799+0000",
    "status": 1,
    "error": "",
    "data": [
		{
			"id": "89",
			"title": "Avenger 1",
			"desc": "Bộ phim siêu anh hùng phần 1...",
			"thumbnail": "http://image...",
			"viewNumbers": 2787124,
			"imdb": 8
		},
		{
			"id": "66",
			"title": "Avenger 2",
			"desc": "Bộ phim siêu anh hùng phần 2...",
			"thumbnail": "http://image...",
			"viewNumbers": 698397,
			"imdb": 7.5
		},
		{
			"id": "145",
			"title": "Avenger 3",
			"desc": "Bộ phim siêu anh hùng phần 3...",
			"thumbnail": "http://image...",
			"viewNumbers": 7428402,
			"imdb": 8
		},
		...
	]
]
```

###6. Thông tin chi tiết phim

`Request params: id phim`

```
{
	"timestamp": "2019-07-30T02:13:59.799+0000",
    "status": 1,
    "error": "",
    "data": {
    	"id": "19",
    	"title": "Ảo thuật gia đấu trí",
    	"thumbnail": "https://thumbnail...",
    	"cover": "https://cover...",
    	"desc": "",
    	"viewNumbers": 123123,
    	"genre": "PLM, PCR, PLVT",
    	"creator": "John Amber",
    	"actor": "William Billy, Smith Jack, Cameron Allie",
    	"country": "US",
    	"duration": "1 giờ 20 phút",
    	"viewNumbers": 1233424,
    	"imdb": 7,
    	"episodeNumbers": 0, (nếu là phim lẻ giá trị là 0)
    	"servers": "Phimmoi, Phimbathu, Kphim"
    	"quality": "HD",
    	"trailer": "https://www.youtube..."
    }
}
```

###7. Lấy link play (theo server và tập phim)
`Request params: id phim, tập phim, server`

```
{
	"timestamp": "2019-07-30T02:13:59.799+0000",
   	"status": 1,
   	"error": "",
  	"data": {
		"server_name": "bilutv",
		"eposide_name": "Tập 1",
		"qualities": [
			{
				"title": "HD",
				"link": "..."
			},
			{
				"title": "720p",
				"link": "..."
			},
			{
				"title": "480p",
				"link": "..."		
			}	
		]
	}
}
```

#Danh sách các website phim

1. [http://www.phimmoi.net](http://www.phimmoi.net)
2. [http://www.kphim.tv](http://www.kphim.tv)
3. [https://bilutv.org](https://bilutv.org)
4. [https://motphim.net](https://motphim.net)