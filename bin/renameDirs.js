#! /usr/bin/env node
const fs = require('fs');

const retrieveDirs = p => fs.readdirSync(p).filter(f => fs.statSync(p+"/"+f).isDirectory())
const dirs = retrieveDirs(process.cwd()).filter(n => n !== '.git' && n !== 'bin' && n !== 'node_modules')
const formattedDirs = dirs.map(dir => dir.split('-')).filter(d => d.length >=3);

function getNewDirName(dir) {
	const newDate = [dir[2], dir[0], dir[1]];
	const dirName = dir.slice(3, dir.length);
	return newDate.concat(dirName).join('-');
}


const newNamedDirs = formattedDirs.map(getNewDirName)

dirs.forEach((dirName, idx) => {
	fs.rename(dirName, newNamedDirs[idx], (err) => {
		if (err) {console.log('err ', err)}
		else {
			console.log(dirName, 'renamded to : ', newNamedDirs[idx])
		}
	});
});
