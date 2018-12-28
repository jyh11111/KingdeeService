1.建表
	
GO

/****** Object:  Table [dbo].[v_PartTmp]    Script Date: 2018/10/30 16:18:06 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[v_PartTmp](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[FItemID] [int] NOT NULL,
	[FNumber] [varchar](80) NULL,
	[Ptype] [varchar](255) NULL,
	[F1] [varchar](255) NULL,
	[V1] [varchar](255) NULL,
	[F2] [varchar](255) NULL,
	[V2] [varchar](255) NULL,
	[F3] [varchar](255) NULL,
	[V3] [varchar](255) NULL,
	[F4] [varchar](255) NULL,
	[V4] [varchar](255) NULL,
	[F5] [varchar](255) NULL,
	[V5] [varchar](255) NULL,
	[F6] [varchar](255) NULL,
	[V6] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[FItemID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

2.建函数

GO

/****** Object:  UserDefinedFunction [dbo].[splitStr]    Script Date: 2018/10/30 16:20:19 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO



-- =============================================
-- Author:	 金运红
-- Create date: 2018-08-10
-- Description:	用于分隔 金碟表t_ICItemCore中Fmodel字段 
--  从字符串
--"Master Batch, Supplier P/N = 5B-04898, Materials =POM 100P, Color Name =Blue, LEGO Color =026-black, Pantone Color =NIL, Special Number =1" 中分隔成表 PTYPE ,F1,V1,F2,V2,F3,V3,F4,V4,F5,V5 ,F6,V6,FNumber
-- =============================================
CREATE FUNCTION [dbo].[splitStr]
(
	@String VARCHAR(MAX),
    @Delimiter VARCHAR(255)
)

RETURNS @temp TABLE (PType VARCHAR(255), F1 VARCHAR(255),V1 VARCHAR(255),F2 VARCHAR(255),V2 VARCHAR(255),F3 VARCHAR(255),V3 VARCHAR(255),F4 VARCHAR(255),V4 VARCHAR(255),F5 VARCHAR(255),V5 VARCHAR(255),F6 VARCHAR(255),V6 VARCHAR(255)  )
AS
BEGIN	
	DECLARE @idx INT=1
	Declare @index int=0;
    DECLARE @slice VARCHAR(MAX) 
    declare @ptype VARCHAR(255),@f1 VARCHAR(255),@v1 VARCHAR(255),@f2 VARCHAR(255),@v2 VARCHAR(255),@f3 VARCHAR(255),@v3 VARCHAR(255),@f4 VARCHAR(255),@v4 VARCHAR(255),@f5 VARCHAR(255),@v5 VARCHAR(255),@f6 VARCHAR(255),@v6 VARCHAR(255)
    declare @charidx int=0 -- 等号=所在位置
    IF LEN(@String) < 1 OR LEN(ISNULL(@String,'')) = 0
        RETURN    
    WHILE @idx != 0
    BEGIN
		set @index=@index+1
        SET @idx = CHARINDEX(@Delimiter,@String)
        IF @idx != 0
            SET @slice = LEFT(@String,@idx - 1)
        ELSE
            SET @slice = @String

        IF LEN(@slice) > 0
			begin
				if (@index=1)
					set @ptype= LTRIM(RTRIM(@slice))
				else if (@index=2)
					begin
						set @charidx=CHARINDEX('=',@slice)
						if @charidx>0
						begin
							set @f1=LTRIM(RTRIM(LEFT(@slice,@charidx-1)))
							set @v1=LTRIM(RTRIM(RIGHT(@slice,len(@slice)-@charidx)))
							if @v1='NIL'
							   set @v1='';
						end
					end
				else if (@index=3)
					begin 		
							set @charidx=CHARINDEX('=',@slice)
							if @charidx>0
						    begin
							set @f2=LTRIM(RTRIM(LEFT(@slice,@charidx-1)))
							set @v2=LTRIM(RTRIM(RIGHT(@slice,len(@slice)-@charidx)))
							if @v2='NIL'
							   set @v2='';
							end
					end
				else if (@index=4)
					begin 		
					set @charidx=CHARINDEX('=',@slice)	
							if @charidx>0
							begin	
							set @f3=LTRIM(RTRIM(LEFT(@slice,@charidx-1)))
							set @v3=LTRIM(RTRIM(RIGHT(@slice,len(@slice)-@charidx)))
							if @v3='NIL'
							   set @v3='';
							END
					end
				else if (@index=5)
					begin 		
					set @charidx=CHARINDEX('=',@slice)	
							if @charidx>0
							begin	
							set @f4=LTRIM(RTRIM(LEFT(@slice,@charidx-1)))
							set @v4=LTRIM(RTRIM(RIGHT(@slice,len(@slice)-@charidx)))
							if @v4='NIL'
							   set @v4='';
							END
					end
				else if (@index=6)
					begin 	
					set @charidx=CHARINDEX('=',@slice)
							if @charidx>0
							begin	
							set @f5=LTRIM(RTRIM(LEFT(@slice,@charidx-1)))
							set @v5=LTRIM(RTRIM(RIGHT(@slice,len(@slice)-@charidx)))
							if @v5='NIL'
							   set @v5='';
							END
					end
					else if (@index=7)
					begin 	
					set @charidx=CHARINDEX('=',@slice)	
							if @charidx>0
							begin	
							set @f6=LTRIM(RTRIM(LEFT(@slice,@charidx-1)))
							set @v6=LTRIM(RTRIM(RIGHT(@slice,len(@slice)-@charidx)))
							if @v6='NIL'
							   set @v6='';
							END
					end
				
            
            end
       

        SET @String = RIGHT (@String, LEN(@String) - @idx)

        IF LEN(@String) = 0
            BREAK
    END    
	 INSERT INTO @temp(PType,F1,V1,F2,V2,F3,V3,F4,V4,F5,V5,F6,V6) VALUES(@ptype,@f1,@V1,@F2,@V2,@F3,@V3,@F4,@V4,@F5,@V5,@F6,@V6)  
	RETURN 
END

GO

3.建立存储过程
 
GO

/****** Object:  StoredProcedure [dbo].[ICItemCore2PartTmp]    Script Date: 2018/10/30 16:30:26 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		金运红
-- Create date: 2018-08-18
-- Description:	将物料表 t_ICItemCore分析写入V_PartTmp临时表中
--              主要要分析Fmodel字段 @FoceUpdate=0 假如 V_PartTmp已存在FitemID则跳过，不存在则插入 
-- =============================================
CREATE PROCEDURE  [dbo].[ICItemCore2PartTmp]
	@ForceUpdate Int =0 --为其它时强制更新
AS
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	declare @fitemid int, @fmodel varchar(255),@fnumber varchar(80),@ptype varchar(255)
	declare @f1 varchar(255),@v1 varchar(255),@f2 varchar(255),@v2 varchar(255),@f3 varchar(255),@v3 varchar(255),@f4 varchar(255),@v4 varchar(255)
	,@f5 varchar(255),@v5 varchar(255),@f6 varchar(255),@v6 varchar(255)

	Declare cursor1 CURSOR For Select  FItemID,Fmodel,FNumber  from t_ICItemCore 
	  --打开游标--
    open cursor1
	fetch next from cursor1 into @fitemid,@fmodel,@fnumber
	while(@@fetch_status=0)---返回被 FETCH 语句执行的最后游标的状态，而不是任何当前被连接打开的游标的状态。
	begin
	--print (@tmp)

	select @ptype=null,@f1=null,@v1=null,@f2=null,@v2=null,@f3=null,@v3=null,@f4=null,@v4=null,@f5=null,@v5=null,@f6=null,@v6=null

	--操作数据库
	select @ptype=PType, @f1=F1,@v1=V1,@f2=F2,@v2=V2,@f3=F3,@v3=V3,@f4=F4,@v4=V4,@f5=F5,@v5=V5,@f6=F6,@v6=V6 from splitstr(@fmodel,',')
	 
		if exists(select 1 from v_PartTmp where FItemID=@fitemid )
		begin
			if  (@ForceUpdate<>0)
			begin
			update v_PartTmp set Fnumber=@fnumber,PType=@ptype, F1=@f1,V1=@v1,F2=@f2,V2=@v2,F3=@f3,V3=@v3,F4=@f4,V4=@v4,F5=@f5,V5=@v5,F6=@f6,V6=@v6 where FItemID=@fitemid
			end
		end
		else
			insert into v_PartTmp(FItemID,PType,FNumber,F1,V1,F2,V2,F3,V3,F4,V4,F5,V5,F6,V6) values(@fitemid,@ptype, @fnumber,@f1,@v1,@f2,@v2,@f3,@v3,@f4,@v4,@f5,@v5,@f6,@v6)
		
		fetch next from cursor1 into  @fitemid,@fmodel,@fnumber --开始循环游标变量
	end 

	close cursor1  --关闭游标
    deallocate cursor1   --释放游标
   
END

GO

5.编写触发器
 
GO

/****** Object:  Trigger [dbo].[TR_After_changetable_]    Script Date: 2018/10/30 16:51:01 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Jinyunhong
-- Create date:2018--08-10
-- Description:	当数据更新删除新增时更新自定义表V_parttmp
-- =============================================
CREATE TRIGGER  [dbo].[TR_After_changetable_]
   ON    [dbo].[t_ICItemCore] 
   FOR  INSERT,DELETE,UPDATE
AS 
BEGIN
	-- SET NOCOUNT ON added to prevent extra result sets from
	-- interfering with SELECT statements.
	SET NOCOUNT ON;
	DECLARE     @IsInsert bit,       @IsUpdate bit,       @IsDelete bit  
    IF EXISTS(SELECT 1 FROM inserted) AND NOT EXISTS(SELECT 1 FROM deleted)   
    SET @IsInsert = 1   
	ELSE  
    SET @IsInsert = 0     
	IF EXISTS(SELECT 1 FROM inserted) AND EXISTS(SELECT 1 FROM deleted)   
    SET @IsUpdate = 1   
	ELSE  
    SET @IsUpdate = 0     
	IF NOT EXISTS(SELECT 1 FROM inserted) AND EXISTS(SELECT 1 FROM deleted)   
		SET @IsDelete = 1   
	ELSE  
		SET @IsDelete = 0
	 
	
	 
	-- Insert statements for trigger here

	if(@IsDelete=1)
		begin
		delete v_parttmp where v_parttmp.FItemID in (select FItemID from deleted)
		return
		end

	declare @fitemid int, @fmodel varchar(255),@fnumber varchar(80),@ptype varchar(255)
	declare @f1 varchar(255),@v1 varchar(255),@f2 varchar(255),@v2 varchar(255),@f3 varchar(255),@v3 varchar(255),@f4 varchar(255),@v4 varchar(255)
	,@f5 varchar(255),@v5 varchar(255),@f6 varchar(255),@v6 varchar(255)
	if(@IsInsert=1 or @IsUpdate=1 )  
	begin
	    --申明游标为Uid
    declare cursor1 cursor 
    for (select  FItemID,fmodel,FNumber  from inserted)
    --打开游标--
    open cursor1
	fetch next from cursor1 into @fitemid,@fmodel,@fnumber
	while(@@fetch_status=0)---返回被 FETCH 语句执行的最后游标的状态，而不是任何当前被连接打开的游标的状态。
	begin
	--print (@tmp)
	
	--操作数据库
	select @ptype=PType, @f1=F1,@v1=V1,@f2=F2,@v2=V2,@f3=F3,@v3=V3,@f4=F4,@v4=V4,@f5=F5,@v5=V5,@f6=F6,@v6=V6 from splitstr(@fmodel,',')
	 
		if exists(select 1 from v_PartTmp where FItemID=@fitemid )
			update v_PartTmp set Fnumber=@fnumber,PType=@ptype, F1=@f1,V1=@v1,F2=@f2,V2=@v2,F3=@f3,V3=@v3,F4=@f4,V4=@v4,F5=@f5,V5=@v5,F6=@f6,V6=@v6 where FItemID=@fitemid
		else
			insert into v_PartTmp(FItemID,PType,FNumber,F1,V1,F2,V2,F3,V3,F4,V4,F5,V5,F6,V6) values(@fitemid,@ptype, @fnumber,@f1,@v1,@f2,@v2,@f3,@v3,@f4,@v4,@f5,@v5,@f6,@v6)
		
		fetch next from cursor1 into  @fitemid,@fmodel,@fnumber --开始循环游标变量
	end 

	close cursor1  --关闭游标
    deallocate cursor1   --释放游标

	end

END

GO




