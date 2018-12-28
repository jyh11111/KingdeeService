var  config =
{ "*.3.2" :
			[{ptype : 'Pigment',
				prop : [ {key:'Supplier P/N',values:[ ]}, 
	    	   			{key:'Materials',values:[]},
	    	   			{key:'Color Name',values:[]},
	    	   			{key:'LEGO Color' ,values:[]},
	    	   			{key:'Pantone Color',values:[]}, 
	    	   			{key:'Special Number',values:[]} 
	    	   	 ]}],
"*.3.3" : [ {ptype : 'Master Batch',
				prop : [{key: 'Supplier P/N'},{key: 'Materials'}, {key:'Color Name'},
							{key:'LEGO Color'}, {key:'Pantone Color'}, {key:'Special Number'} ]
				} ],	
"*.3.4" : [ {ptype : 'Motor',
				prop : [{key: 'R-Voltage'}, {key:'No-Load Speed'}, {key:'Stall Torque'},
					{key:'Size Type',values:['120','130','140','180','260','280','300','360','380','500','Others']},{key: 'DV',values:['Yes', 'None']},
					{key: 'Motor Type',values:['3 Cored DC', '5 Cored DC', 'Coreless DC', 'Brushlee DC', 'AC Motor', 'Stepper Motor', 'Servo Motor', 'Others']} ]
				} ],			
"*.3.5" : [{ptype : 'Bearing',
				prop : [{key: 'Bearing Type',values:["Ball Bearing"," Linear Bearing"," Others"] },
					{key:'Materials',values:["Stainless Steel"," Steel"," Others"]},
					{key:'Out Side Diameter'},
					{key:'In Side Diameter'},
					{key:'Thinkness'} 
					]},
			{ptype : 'Bush',
				 prop : [{key: 'Bush Type',values:["Oil Bush"," Bush"," Sleeve"," Others"]},
					 {key:'Materials',values:["Stainless Steel"," Steel"," Brass"," Compound"," Others"]}, {key:'Out Side Diameter'},
					 {key:'In Side Diameter'},{key:'Thinkness'}
					 ]},
			{ptype : 'Clockwork',
				 prop : [{key: 'Clockwork Spring Type'},
					 {key:'Materials'},
					 {key:'Width / Diametr'},{key: 'Length'}, {key:'Thickness'}
					 ]},
			{ptype : 'Connector',
				prop : [{key:'Connector Type'}, {key:'Materials'}, {key:'Pin'}, {key:'Pitch'},
						{key:"Pin Size"}, {key:'Wire Length'}
					 ]},
			{ptype : 'Flywheel',
				prop : [{key:'Flywheel Type',values:['Flywheel', 'Pulley', 'Balance Wheel', 'Reel', 'Others']}, 
					{key:'Materials',values:['Brass','Copper','Stainless Steel', 'Steel', 'A3']},
					{key:'Out Side Diameter'}, {key:'Hole Diameter'},
					{key:"Thickness"} 
					 ]},
					 
			{ptype : 'Gear',
				prop : [{key: 'Gear Type',values:['Spur Pinion','Helical Pinion','Bevel Gear','Helical Gear','Crown Gear','Compound Gear','Worm','Others']},
					    {key:'Materials',values:['Brass,Copper','Stainless Steel','Steel','Iron (Fe)','Aluminum Alloy','Zinc Alloy', 'Others']},
					    {key:'Module-Pinion'},
					    {key:'Teeth-Pinion'},{key:'Height-Pinion'},
					    {key:'Hole DiameterHole'}
					 ]},
			{ptype : 'Heat Sink',
				prop : [ {key:'Heat Sink Type'},
					     {key: 'Materials',values:['Brass','Copper','Aluminum Alloy','Zinc Alloy', 'Others']},
					     {key:'Outside Width'}, {key:'Outside Length'},
					     {key:'Outside Height'}, {key:'ColorHeat Sink Type'} ]
					},
			{ptype : 'Magnet',
				prop : [{key: 'Magnet Type',values:['Magnet','Ferrite Core','Magnetic Powder Cores', 'Others' ]},
					    {key:'Materials',values:['Sintered NdFeB' ,'Bonded NdFeB','Ferrite','Alnico','SmCo','Rubber Ferrite','NdFeB Rubber Magent','Plastic Magent','Mn-Zn','Ni-Zn','Others']},
					     {key:'Width / Diameter'}, {key:'Height'}, {key:'Pole'},
					     {key:'Special Number'} ]
					},
			{ptype : 'Metal Plate',
				prop : [ {key:'Metal Plate Type'}, {key:'Materials',values:['DT4E','C2680-R','Iron (Fe)','Brass','Copper','Stainless Steel','Steel', 'Others']},
					     {key:'Width / Diameter'}, {key:'Length'}, {key:'Height'} ]
					},
			{ptype : 'Plastic Plate',
				prop : [ {key:'Plastic Plate Type',values:['Tube','Shaft','Washer','Gear','Parts','Others']}, {key:'Materials'},
					{key:'Width / Diameter'}, {key:'Length'}, {key:'Height'} ]
					},
			{ptype : 'Plastic Sleeve',
				prop : [{key: 'Plastic Sleeve Type'}, {key:'Materials'},
					    {key:'Width / Diameter'}, {key:'Length'}
					  ]},
			{ptype : 'Rivert/Sleeves Parts',
				prop : [ {key:'Parts Type',values:['Rivet','Sleeve','Nut','Pin','Others']}, {key:'Materials',values:['Brass','Copper','Stainless Steel','Steel','Iron (Fe)','Aluminum','Others']},
					     {key:'Out Side Diameter'}, {key:'In Side Diameter'},
					     {key:'Height'}
					]},
			{ptype : 'Rubber Parts',
				prop : [{key: 'Rubber Parts Type',values:['Tube','Spacer','Washer','Wheel','Sleeve','Parts','Others']},{key: 'Materials'},
					    {key:'ÞWidth / Diameter'}, {key:'Length'}, {key:'Height'},
					    {key:'Special Number'} ]
					},
			{ptype : 'Screw',
				prop : [{key: 'Screw Type',values:['Metric screws','Inch Screw','Self Tapping(Mettal)','Self Tapping(Plastic)','Self Tapping (Wooden)','Others']}, 
					{key:'Materials',values:['Brass','Copper','Stainless Steel','Steel','Iron (Fe)','Aluminum Alloy','Zinc Alloy','Nylon Resin','Others']}, {key:'Screw Diameter'},
					{key:'Length'}, {key:'Screw Head Style',values:['Round Head','Flat Head','OVAL Head','Pan Head','Indented Hex Head','TRUSS Head','Washer Head','Spring Head','Others']},
					{key:'Driving Recess Type',values:['Cross (Philips)','Flat (Slotted)','Hexagon','Hex Socket (ALLEN)','TORX','Y-Type','Six-Lobe','Triangle','H-Type','Others']}
					]},
			{ptype : 'Shaft',
				prop : [ {key:'Shaft Type',values:['Plain Shaft','Knurling Shaft','Others']}, {key:'Materials',values:['Brass','Copper','Stainless Steel','Steel','Iron (Fe)','Aluminum Alloy','Zinc Alloy', 'Others']}, {key:'Diameter'},
					     {key:'Length'}, {key:'Knurling'}, {key:'Shaft Type'}
					 ]},
			{ptype:'Plug',
				prop:[ {key:'Socket Type'},{key:'Materials'},{key:'Pin'},{key:'Pitch'},{key:'Pin Size'}					
					
				]},	 
			
		 
			{ptype : 'Solider',
				prop : [ {key:'Solider Type',values:['No-Pd Soilder Wire','No-Pd Solider Bar','Others']}, {key:'Materials'},
							{key:'Width / Diameter'}, {key:'Length'}, {key:'Weight'},
							{key:'CoresSolider Type'} ]
					},
			{ptype : 'Spring',
				prop : [ {key:'Spring Type',values:['Compression Spring','Extension Spring','Torsion Spring','Tapered Spring','Garter Spring','Wire Form Spring','Spring Ring','Pin Spring','Flat Spring','Hair Spring','Others']},
						 {key:'Materials',values:['Stainless Steel','Steel','Copper Alloy','Cobait / Nickel Based Alloy','Tungsten','Aluminum','Titanium','Urethane','EPDM','Others']}, {key:'Width Diameter'},
							{key:'Outside Diameter'}, {key:'Height'}, {key:'Special Number'} ]
					},
			{ptype : 'Sub-Assembly',
				prop : [ {key:'Sub-Assembly Type',values:['Electrical','Electronics','Mechanical','Plastic Assembly','Others']}, {key:'Project Number'},
						    {key:'Product Model'} ]
					},
			{ptype : 'Switch',
				prop : [ {key:'Switch Type',values:['Toggle Switch','Selector Switch','Power Switch','Push Switch','Push Button Switch','Micro Switch','Emergency switch','Others']}, {key:'Sector'}, {key:'Pin'},
					     { key:'Section Pole'}, {key:'Terminals'}
					]},
			{ptype : 'Washer/Nuts',
				prop : [ {key: 'Washer /Nuts Type',values:['Flat Washer','Split Washer','Ex-Tooth Lock Washer','In-Tooth Lock Washer','Wave Washer','Nut','e-Ring','Others']}, {key:'Materials',values:['Stainless Steel', 'Steel', 'Plastic', 'FishPaper', 'Manganese Steel', 'Others']},
					     {key:'Width / Diameter'}, {key:'Nut Knurling'},
					     {key:'Height / Thickness'},
					     {key:	'Screw / Inside DiameterWasher'} ]
					},
			{ptype:'Others',
				prop:[{key:'Others Type'},{key:'Materials',values:['Stainless Steel', 'Steel', 'Plastic', 'FishPaper', 'Manganese Steel', 'Others']},{key:'Width / Diameter'},{key:' Lenght'},{key:'Height / Thickness'},{key:'Weight'}
					
					]		
			}		

			],
"*.3.6" : [
			{ptype : "Battery",
					prop : [
						 {key:"Battery Type",values:['Primary Battery','Rechargeable Battery' ]},
						{key:"Materials",values:['Alkaline','Zinc–carbon','Nickel–cadmium','Nickel–metal hydride','Lithium','Lithium-ion','Other']}	,
						{key:"Battery Size Type",values:[]},{key:"Voltage",values:[]},{key:"Brand",values:[]}
						]},
			{ptype : "Capacitor",
					prop : [ {key:'Capacitor Type',values:['Flat Capacitor','Spherical Capacitor','Cylindrical Capacitor','SMD Capacitor','Others']},
						{key:'Materials',values:['Electrolytic Capacitor','Mica capacitor','Ceramic capacitor','Tantalum Capacitor','Others']}, {key:'Value'},
						{key:'Voltage'}, {key:'Special Number'}]
				     },
			{ptype:"Diode",	 
				    prop:[{key:'Diode Type',values:['LED','Zener Diode','Varactor Diode' ,'Pin Diode','Rectifier Diode','Photo Diode','Others']},{key:'Wattage / Current'},{key:'Diameter'},{key:'Voltage'},{key:'Diode Number'}]	 	     
					},
			{ptype:"Inductor ",	 
					    prop:[{key:'Inductor Type' }]	 	     
						},
			{ptype : "PCB",
					prop : [ {key:'PCB Type',values:['Raw PCB','Servo Digital PCBA','Servo Analog PCBA','Project Base PCBA','Others']}, {key:'Materials',values:['Bakelite','Glass Fiber','Carbon Fiber','Ceramic','FPC','Others']}, {key:'Project Number'},
						{key:'Product Model'}, {key:'Special Number'} ]
					},
			{ptype:'Resistor',
					prop:[{key:"Resistor Type",values:['Fixed']}, {key:'Materials',values:['Carbon Resistor','Ceramic Resistor','Metal Flm Resistor','Wire Resistor']}, {key:'Value'}, {key:'Voltage'}]
					},
			{ptype : "Potentionmeter",
					prop : [ {key:'Potentionmeter Type'}, {key:'Materials'}, {key:'Value'},
						{key:'Wattage'}, {key:'Supplier P/N'} ]
					},
			{ptype : "Wire",
					prop : [ {key:'Wire Type',values:[ 'Wire Roll','Cable Roll','Wire Piece','Cable Piece']}, {key:'Materials'}, {key:'Wire Gauge Size'},
						{key:'Wire Length'}, {key:'Pins / Wires'}, {key:'Special Number'} ]
			},
			{ptype:'Others',
				    prop:[{key:'Others Type'},{key:'Materials'}, {key:'Project Number'}, {key:'Product Model'},{key:'Basic Spec'},{key:'Common Name'}]
			
				}
			
			],
"*.3.7" : [
			{ptype:'Blister',
				prop:[{key:'Blister Type',values:['Ball Bearing', 'Linear Bearing', 'OthersClamp Shell Blister','Tray Blister','Cover Blister','Half Clamp Shell Blister','Others']}, 
					{key:'Materials',values:['PVC','PET','O-PET','PET-G','O-PP','HDPE','Others']}, {key:'Project Number'}, {key:'Product Model'}, {key:'VG Drawing No'}]
			},
			{ptype : 'Blister Tray',
					prop : [{key: 'Blister Type',values:['Tray Blister','Cover Blister','Others']},
						    {key:'Materials',values:['PVC','PET','O-PET','PET-G','O-PP','HDPE','Others']}, {key:'Project Number'},
						    {key:'Product Model'}, {key:'VG Drawing No'} ]
					},
			{ptype : 'Carton',
						prop : [ {key:'Carton Type',values:['Outer VG STD Carton','Inner VG STD Carton','Project Outer Carton','Project Inner Carton','Others']}, {key:'Materials'}, {key:'Outside Width'},
							{key:'Outside Length'}, {key:'Outside Height'},
							{key:'Special Number'} ]
						},
			{ptype : 'Pallet',
							prop : [ {key:'Pallet Type',values:['2-Way Reversible','2-Way Close Boarded','4-Way Close Boarded','4-Way Perimeter Base','4-Way Open Boarded','Euro Pallet','Others']},
									{key:'Materials',values:['Plastic Pallet','Wood Pallet','Metal Pallet','Aluminium Pallet','Cardboards Pallet','Presswood Pallet','Others']}, {key:'Width'}, {key:'Length'},
								{key:'Height'} ]
						 },
			{ptype : 'Gift Box',
							prop : [ {key:'Gift Box Type'}, {key:'Materials',values:['1Side Coated Paper','2Side Coated Paper','Halftone Paper','White Board','Others']}, {key:'Outside Width'},
									{key:'Outside Length'}, {key:'Outside Height'},
									{key:'Paper Weight Type'} ]
							     },
		    {ptype : 'Label',
							prop : [ {key:'Label Type',values:['Laser Label','Name Plate']}, {key:'Materials',values:['PP Coating Paper','Matt Silver PET','Halftone Paper','Others']}, {key:'Width'}, {key:'Length'},
											{key:'Thickness'}, {key:'Product Model'} ]
		    					},
			{ptype : 'Manual',
							prop : [ {key:'Manual Type'}, {key:'Materials',values:['1Side Coated Paper','2Side Coated Paper','Halftone Paper','White Board','Others']}, {key:'Width'}, {key:'Length'},
									{key:'Thickness'}, {key:'Paper Weight Type'} ]
								},	
			{ptype : 'Card/Paper',
						prop : [ {key:'Card/Paper Type',values:['Card Board','Inner Partition Card','EPE Board','Kraft Paper','Others']}, {key:'Materials'},
								{key:'Width / Diameter'}, {key:'Length'}, {key:'Thickness'} ]
								},
			{ptype : 'Cable Tie/Fresh Paper',
					prop : [ {key:'Parts Type',values:['Cable Tie','Iron Core Tie','Wrap Sheet']}, {key:'Materials'}, {key:'Width / Diameter'},
						{key:'Length'}, {key:'Thickness'}, {key:'Special Number'} ]
					},
			{ptype : 'Polybag',
						prop : [ {key:'Polybag Type',values:['PolyBag','BubbleBag','ZipperBag']}, {key:'Materials',values:['PVC','PET','PE','HDPE','LDPE','PLA','Others']}, {key:'Width'},
							{key:'Length'}, {key:'Thickness'}, {key:'VG Drawing No'} ]
					},			
		
			{ptype : 'Print Card',
					prop : [ {key:'Print Card Type',values:['Single Printed Card','Double Printed Card']},
							{key:'Materials',values:['1Side Coated Paper','2Side Coated Paper','Halftone Paper','White Board','Others']},
							{key:'Width / Diameter'}, {key:'Length'}, {key:'Thickness'},
							{key:'VG Drawing No'} ]
			  },
			{ptype : 'Others',
					prop : [ {key:'Others Type'}, {key:'Materials'},
						{key:'Width / Diameter'}, {key:'Length'},
						{key:'Thickness/Height'}, {key:'Project Number'} ]
				  }
			],
"*.3.8" : [
			{ptype : 'Adhesive',
					prop : [ {key:'Adhesive Type',values:['Adhesive','Glue,Thinner','Solvent']}, {key:'Materials'}, {key:'Common Name'} ]
					},
			{ptype : 'Lubricant',
						prop : [ {key:'Lubricant Type',values:['Lubricant','Grease','Oil','Others']}, {key:'Materials'}, {key:'Common Name'} ]
					},
			{ptype : 'Ink',
					prop : [ {key:'Ink Type',values:['Pad Print Ink', 'Spray Print Ink']}, {key:'Materials'}, {key:'Color Name'},
						{key:'LEGO Color'}, {key:'Pantone Color'} ]
				},				
			{ptype : 'Thinner',
					prop : [ {key:'Thinner Type'}, {key:'Materials'}, {key:'Common Name'} ]
				},
			{ptype:'Powder',
					prop:[{key:'Powder Type'},{key:'Materials'},{key:'Common Name'}]
				},
			{ptype:'Others',
					prop:[{key:'Others Type'},{key:'Materials'},{key:'Width/Diamether'},{key:'Length'},{key:'Common Name'} ,{key:'Common Expenses',values:['Yes', 'None']}]
				}
				]	
	
 
	
}