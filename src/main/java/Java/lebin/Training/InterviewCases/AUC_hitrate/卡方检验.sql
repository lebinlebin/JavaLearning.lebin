SELECT
feature_name,SUM(chi_square) as chi_square
FROM(
	SELECT
	t1.feature_name,
	t1.feature_value,
	t1.label,
	--推导以后
	(NVL(Nab,0)*N-Na*Nb)*(NVL(Nab,0)*N-Na*Nb)/(Na*Nb*N) as chi_square
	FROM
	(
		SELECT t1.feature_name,feature_value,label,Na,Nb
		FROM
		(
			SELECT feature_name,feature_value,COUNT(1) as Na FROM chi_squre_test_caculate
			GROUP BY feature_name,feature_value
		)t1 join
		(
			SELECT feature_name,label,COUNT(1) as Nb FROM chi_squre_test_caculate
			GROUP BY feature_name,label
		)t2 on t1.feature_name=t2.feature_name
	)t1
	left join
	(
		SELECT feature_name,feature_value,label,COUNT(1) as Nab FROM chi_squre_test_caculate
		GROUP BY feature_name,feature_value,label
	)t2 on t1.feature_name=t2.feature_name and t1.feature_value=t2.feature_value and t1.label=t2.label
	left join
	(
		SELECT feature_name,COUNT(1) as N FROM chi_squre_test_caculate GROUP BY feature_name
	)t3 on t1.feature_name=t3.feature_name) GROUP BY feature_name